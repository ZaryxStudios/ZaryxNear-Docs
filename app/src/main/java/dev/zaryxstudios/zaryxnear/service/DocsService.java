package dev.zaryxstudios.zaryxnear.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocList;
import dev.zaryxstudios.zaryxnear.dto.DocResponse;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Service responsible for loading, caching and serving Markdown documentation files.
 * Implements efficient caching with O(1) lookup time using ConcurrentHashMap.
 *
 * During startup, this service scans classpath resources and caches token counts.
 *
 * @author Zaryx Studios
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DocsService {

    private final ResourceLoader resourceLoader;
    private final TokenCountService tokenCountService;
    private final AtomicLong failedLoadCount = new AtomicLong();

    private final Map<String, DocResponse> docsCache = new ConcurrentHashMap<>();
    private final Map<String, Set<String>> categoryCache = new ConcurrentHashMap<>();

    private static final String DOCS_PATTERN = "classpath:docs/**/*.md";
    private static final long MAX_IN_MEMORY_SIZE = 256 * 1024; // 256KB

    @PostConstruct
    public void loadDocs() {
        try {
            Resource[] resources = ResourcePatternUtils
                    .getResourcePatternResolver(resourceLoader)
                    .getResources(DOCS_PATTERN);

            for (Resource resource : resources) {
                if (!resource.exists() || !resource.isReadable())
                    continue;

                String filename = resource.getFilename();
                if (filename == null)
                    continue;

                String uri = resource.getURI().toString();

                String relativePath = extractRelativePath(uri);
                if (relativePath == null)
                    continue;

                String content = readResourceContent(resource);
                long tokens = tokenCountService.countTokens(content);

                String docPath = relativePath.substring(0, relativePath.lastIndexOf('.'));

                docPath = cleanPath(docPath);

                docsCache.put(docPath, new DocResponse(content, tokens));

                updateCategoryCache(docPath);

                log.info("Loaded doc: {} ({} chars, {} tokens)", docPath, content.length(), tokens);
            }
        } catch (IOException e) {
            failedLoadCount.incrementAndGet();
            log.error("Failed to load documentation files from: {}", DOCS_PATTERN, e);
            loadFromBackup();
        }
    }

    private String readResourceContent(Resource resource) throws IOException {
        long contentLength = resource.contentLength();

        if (contentLength > MAX_IN_MEMORY_SIZE) {
            return streamLargeFile(resource);
        }

        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    private String streamLargeFile(Resource resource) throws IOException {
        try (java.io.InputStream is = resource.getInputStream();
             java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(is, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            return sb.toString();
        }
    }

    private String extractRelativePath(
            String uri
    ) {
        String path = uri;

        if (path.startsWith("jar:")) {
            int exclamation = path.indexOf("!/");

            if (exclamation != -1)
                path = path.substring(exclamation + 2);
        }

        if (path.startsWith("file:"))
            path = path.substring(5);

        int docsIndex = path.indexOf("docs/");
        if (docsIndex == -1)
            return null;

        return path.substring(docsIndex + 5);
    }

    private String cleanPath(
            String path
    ) {
        return path
                .replace("build/resources/main/docs/", "");
    }

    private void updateCategoryCache(
            String docPath
    ) {
        String[] parts = docPath.split("/");

        String category = parts.length > 1
                ? String.join("/", Arrays.copyOf(parts, parts.length - 1))
                : "";

        String docName = parts.length > 1
                ? parts[parts.length - 1]
                : docPath;

        categoryCache.computeIfAbsent(category, key -> new TreeSet<>()).add(docName);
    }

    /**
     * Retrieves a documentation file from cache.
     *
     * @param category The category path (e.g., "minecraft/plugins").
     * @param docId    The document identifier without extension.
     * @return DocResponse containing content and token count, or null if not found.
     */
    public DocResponse getDoc(
            String category,
            String docId
    ) {
        String fullPath = normalizePath(category) + "/" + docId;
        return docsCache.get(fullPath);
    }

    public Map<String, DocList> getCategoryTreeProto() {
        return categoryCache.entrySet().stream()
                .filter(entry -> !entry.getKey().isEmpty())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> DocList.newBuilder()
                                .addAllDocId(entry.getValue())
                                .build()
                ));
    }

    private void loadFromBackup() {
        log.info("Attempting to load docs from backup location...");
        try {
            Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:backup-docs/**/*.md");
            for (Resource resource : resources) {
                if (!resource.exists() || !resource.isReadable()) continue;
                String uri = resource.getURI().toString();
                String relativePath = extractRelativePath(uri);
                if (relativePath == null) continue;

                String content = readResourceContent(resource);
                long tokens = tokenCountService.countTokens(content);
                String docPath = cleanPath(relativePath.substring(0, relativePath.lastIndexOf('.')));

                docsCache.put(docPath, new DocResponse(content, tokens));
                updateCategoryCache(docPath);
                log.info("Loaded backup doc: {} ({} chars, {} tokens)", docPath, content.length(), tokens);
            }
        } catch (IOException err) {
            log.error("Backup docs loading also failed", err);
        }
    }

    private String normalizePath(
            String path
    ) {
        if (path == null)
            return "";

        return path
                .replaceAll("^/+|/+$", "")
                .replace("\\", "/");
    }
}
