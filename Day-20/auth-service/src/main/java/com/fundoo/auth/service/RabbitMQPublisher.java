package com.fundoo.auth.service;

import com.fundoo.auth.config.RabbitMQConfig;
import com.fundoo.auth.dto.AuthEventMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RabbitMQPublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendLoginEvent(String email) {
        try {
            AuthEventMessage message = new AuthEventMessage("LOGIN_SUCCESS", email, LocalDateTime.now());
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
        } catch (Exception e) {
            System.err.println("RabbitMQ dispatch failed: " + e.getMessage());
        }
    }
}
