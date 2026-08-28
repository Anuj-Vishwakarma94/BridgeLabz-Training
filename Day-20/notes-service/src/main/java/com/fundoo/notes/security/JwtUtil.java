package com.fundoo.notes.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtUtil {

    private final String secretKey = "fundoo-notes-secret-key-for-jwt-authentication-123456789";

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUserId(String token) {
        Claims payload = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return payload.getSubject();
    }

    public String extractEmail(String token) {
        Claims payload = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        String emailClaim = payload.get("email", String.class);
        if (emailClaim != null) {
            return emailClaim;
        }
        return payload.getSubject();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}
