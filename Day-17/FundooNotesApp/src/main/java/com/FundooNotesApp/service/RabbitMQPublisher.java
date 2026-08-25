package com.FundooNotesApp.service;

import com.FundooNotesApp.config.RabbitMQConfig;
import com.FundooNotesApp.dto.AuthEventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQPublisher.class);
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendRegisterEvent(String email) {
        AuthEventMessage message = new AuthEventMessage(
                "REGISTER",
                email,
                "User account registered successfully."
        );
        publish(RabbitMQConfig.REGISTER_ROUTING_KEY, message);
    }

    public void sendLoginEvent(String email) {
        AuthEventMessage message = new AuthEventMessage(
                "LOGIN",
                email,
                "User logged into Fundoo Notes."
        );
        publish(RabbitMQConfig.LOGIN_ROUTING_KEY, message);
    }

    public void sendForgotPasswordEvent(String email, String resetToken) {
        AuthEventMessage message = new AuthEventMessage(
                "FORGOT_PASSWORD",
                email,
                "Password reset requested. Reset Token: " + resetToken
        );
        publish(RabbitMQConfig.FORGOT_PASSWORD_ROUTING_KEY, message);
    }

    private void publish(String routingKey, AuthEventMessage message) {
        try {
            log.info("[RabbitMQ Publisher] Publishing event '{}' for user: {}", message.getEventType(), message.getEmail());
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, routingKey, message);
        } catch (Exception e) {
            log.warn("[RabbitMQ Publisher] Could not publish message to RabbitMQ (is RabbitMQ running?): {}", e.getMessage());
        }
    }
}
