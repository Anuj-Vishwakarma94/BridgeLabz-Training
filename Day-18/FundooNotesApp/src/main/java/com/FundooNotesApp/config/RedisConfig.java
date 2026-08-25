package com.FundooNotesApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis configuration.
 *
 * We use a plain String-to-String RedisTemplate so we can store and
 * retrieve JWT token strings under simple string keys.
 *
 * Connection details (host / port) come from application.properties:
 *   spring.data.redis.host=localhost
 *   spring.data.redis.port=6379
 *
 * Spring Boot auto-configures a Lettuce-based RedisConnectionFactory
 * from those properties, which we inject here.
 */
@Configuration
public class RedisConfig {

    /**
     * Provides a RedisTemplate typed as {@code <String, String>}.
     * Both key and value serialisers use StringRedisSerializer so the
     * data is human-readable in redis-cli.
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);

        template.afterPropertiesSet();
        return template;
    }
}
