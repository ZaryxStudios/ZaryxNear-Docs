package dev.zaryxstudios.zaryxnear.service;

import org.springframework.stereotype.Service;

@Service
public class TokenCountService {

    /**
     * Simple tokenizer fallback (whitespace-based) for local execution.
     */
    public long countTokens(
            String text
    ) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        // Basic fallback; production can be replaced by a real tokenizer.
        return text.trim().split("\\s+").length;
    }
}
