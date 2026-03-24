package dev.zaryxstudios.zaryxnear.service;

import dev.zaryxstudios.zaryxnear.dto.DocResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DocsServiceTest {

    @Autowired
    private DocsService docsService;

    @Test
    void shouldLoadAllDocs() {
        DocResponse response = docsService.getDoc("minecraft/zaryxnear", "test-doc");
        assertNotNull(response, "Test document should be loaded from classpath tests folder");
        assertTrue(response.getContent().contains("This is a test document"));
        assertTrue(response.getTokens() > 0);
    }

    @Test
    void shouldHandleInvalidPath() {
        DocResponse response = docsService.getDoc("nonexistent/path", "does-not-exist");
        assertNull(response);
    }

    @Test
    void shouldNormalizePath() {
        DocResponse response1 = docsService.getDoc("/minecraft/zaryxnear/", "test-doc");
        DocResponse response2 = docsService.getDoc("minecraft\\zaryxnear", "test-doc");

        assertNotNull(response1);
        assertEquals(response1.getContent(), response2.getContent());
    }
}
