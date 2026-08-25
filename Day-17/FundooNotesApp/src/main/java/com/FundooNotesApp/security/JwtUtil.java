package com.FundooNotesApp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * JWT utility class.
 *
 * Day 16 addition — Redis token caching:
 *   - Tokens are cached in Redis under the key "token:<jwt_string>" with a TTL
 *     equal to their remaining validity window.
 *   - {@link #validateToken(String)} checks Redis first (O(1) lookup) and only
 *     falls back to full JWT signature parsing when the cache misses.
 *   - {@link #cacheToken(String, long)} stores the token in Redis.
 *   - {@link #evictToken(String)} removes the token (e.g. after password reset).
 */
@Component
public class JwtUtil {

    private static final String REDIS_KEY_PREFIX = "token:";

    private final String secretKey =
            "fundoo-notes-secret-key-for-jwt-authentication-123456789";

    // Injected by Spring; the RedisTemplate<String,String> bean is defined in RedisConfig.
    private final RedisTemplate<String, String> redisTemplate;

    public JwtUtil(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // -------------------------------------------------------------------------
    // Token generation
    // -------------------------------------------------------------------------

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

    // -------------------------------------------------------------------------
    // Redis cache helpers
    // -------------------------------------------------------------------------

    /**
     * Stores the JWT string in Redis with a TTL so the entry auto-expires.
     *
     * @param token      the raw JWT string
     * @param ttlSeconds how long (seconds) until Redis evicts the entry
     */
    public void cacheToken(String token, long ttlSeconds) {
        redisTemplate.opsForValue()
                .set(REDIS_KEY_PREFIX + token, "valid", ttlSeconds, TimeUnit.SECONDS);
    }

    /**
     * Returns {@code true} if the token is present in the Redis cache.
     */
    public boolean isTokenCached(String token) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(REDIS_KEY_PREFIX + token));
    }

    /**
     * Removes the token from Redis — call this after a password reset or logout
     * to immediately invalidate the token even if its JWT expiry has not elapsed.
     */
    public void evictToken(String token) {
        redisTemplate.delete(REDIS_KEY_PREFIX + token);
    }

    // -------------------------------------------------------------------------
    // Token validation & claim extraction
    // -------------------------------------------------------------------------

    /**
     * Validates a JWT token.
     *
     * Fast path: if the token is in the Redis cache it is considered valid
     * without re-parsing the signature (saves CPU on every authenticated request).
     *
     * Slow path: parse and verify the JWT signature, then cache the token for
     * subsequent requests.
     */
    public boolean validateToken(String token) {
        // Fast path — Redis cache hit
        if (isTokenCached(token)) {
            return true;
        }

        // Slow path — full JWT signature verification
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            // Cache for the remaining TTL
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

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(
                secretKey.getBytes(StandardCharsets.UTF_8)
        );
    }
}