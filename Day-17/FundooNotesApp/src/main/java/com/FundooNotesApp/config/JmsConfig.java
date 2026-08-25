package com.FundooNotesApp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.jms.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

/**
 * JMS configuration using ActiveMQ Classic (Spring Boot auto-configured broker).
 *
 * Spring Boot's ActiveMQAutoConfiguration starts an embedded in-memory broker
 * automatically — we don't define a ConnectionFactory bean here so Boot's
 * auto-configuration takes full control (avoids the vm:// scheme issue in
 * ActiveMQ Classic 6.x).
 *
 * We only define:
 *   1. An ObjectMapper with JavaTimeModule for LocalDateTime support
 *   2. A MappingJackson2MessageConverter — sends JSON TextMessages instead
 *      of Java ObjectMessages (bypasses deserialization trust filters)
 *   3. JmsTemplate and listener factory that both use the JSON converter
 */
@Configuration
@EnableJms
@SuppressWarnings("deprecation")
public class JmsConfig {

    /**
     * ObjectMapper with JavaTimeModule so LocalDateTime round-trips as ISO-8601.
     */
    @Bean
    public ObjectMapper jmsObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    /**
     * Converts JMS messages to/from JSON TextMessages.
     * _type header carries the Java class name for deserialization.
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter(ObjectMapper jmsObjectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(jmsObjectMapper);
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    /**
     * JmsTemplate — uses Spring Boot's auto-configured ConnectionFactory
     * (embedded ActiveMQ broker) and the Jackson JSON converter.
     */
    @Bean
    public JmsTemplate jmsTemplate(
            ConnectionFactory connectionFactory,
            MessageConverter jacksonJmsMessageConverter) {

        JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setMessageConverter(jacksonJmsMessageConverter);
        template.setDefaultDestinationName("note.reminders");
        return template;
    }

    /**
     * Container factory for @JmsListener — same auto-configured ConnectionFactory
     * and JSON converter so the listener receives a NotificationMessage POJO.
     */
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            ConnectionFactory connectionFactory,
            MessageConverter jacksonJmsMessageConverter) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jacksonJmsMessageConverter);
        factory.setSessionAcknowledgeMode(jakarta.jms.Session.AUTO_ACKNOWLEDGE);
        return factory;
    }
}
