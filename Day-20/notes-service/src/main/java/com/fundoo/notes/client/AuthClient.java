package com.fundoo.notes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "auth-service", fallback = AuthClientFallback.class)
public interface AuthClient {

    @GetMapping("/api/auth/validate")
    Map<String, Object> validateToken(@RequestHeader("Authorization") String token);
}
