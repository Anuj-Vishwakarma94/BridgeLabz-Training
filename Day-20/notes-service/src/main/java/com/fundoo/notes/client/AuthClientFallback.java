package com.fundoo.notes.client;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthClientFallback implements AuthClient {

    @Override
    public Map<String, Object> validateToken(String token) {
        Map<String, Object> fallbackResponse = new HashMap<>();
        fallbackResponse.put("valid", false);
        fallbackResponse.put("message", "Auth Service is currently unavailable. Circuit breaker triggered fallback.");
        return fallbackResponse;
    }
}
