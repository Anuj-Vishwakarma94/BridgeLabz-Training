package com.fundoo.auth.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private static final String REDIS_KEY_PREFIX = "token:";
    private final String secretKey = "fundoo-notes-secret-key-for-jwt-authentication-123456789";

    private final RedisTemplate<String, String> redisTemplate;

    public JwtUtil(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String generateToken(Long userId, String email) {
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("email", email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getKey())
                .compact();
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .claim("email", email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getKey())
                .compact();
    }

    public String generateResetToken(String email) {
        return Jwts.builder()
                .subject(email)
                .claim("purpose", "reset_password")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(getKey())
                .compact();
    }

    public void cacheToken(String token, long ttlSeconds) {
        if (redisTemplate != null) {
            try {
                redisTemplate.opsForValue()
                        .set(REDIS_KEY_PREFIX + token, "valid", ttlSeconds, TimeUnit.SECONDS);
            } catch (Exception ignored) {
            }
        }
    }

    public boolean isTokenCached(String token) {
        if (redisTemplate != null) {
            try {
                return Boolean.TRUE.equals(redisTemplate.hasKey(REDIS_KEY_PREFIX + token));
            } catch (Exception ignored) {
            }
        }
        return false;
    }

    public void evictToken(String token) {
        if (redisTemplate != null) {
            try {
                redisTemplate.delete(REDIS_KEY_PREFIX + token);
            } catch (Exception ignored) {
            }
        }
    }

    public boolean validateToken(String token) {
        if (isTokenCached(token)) {
            return true;
        }

        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            long remainingMs = claims.getExpiration().getTime() - System.currentTimeMillis();
            if (remainingMs > 0) {
                cacheToken(token, remainingMs / 1000);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTokenValid(String token) {
        return validateToken(token);
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
