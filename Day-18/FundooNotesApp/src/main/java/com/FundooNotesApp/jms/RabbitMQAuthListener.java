package com.FundooNotesApp.jms;

import com.FundooNotesApp.config.RabbitMQConfig;
import com.FundooNotesApp.dto.AuthEventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.FundooNotesApp.service.EmailService;

/**
 * RabbitMQ consumer — listens for authentication events (register, login, forgot password)
 * and triggers SMTP email notifications.
 */
@Component
public class RabbitMQAuthListener {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQAuthListener.class);
    private final EmailService emailService;

    public RabbitMQAuthListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitMQConfig.REGISTER_QUEUE)
    public void onUserRegistered(AuthEventMessage message) {
        log.info("==================================================");
        log.info("[RabbitMQ CONSUMER] User Registration Event Received");
        log.info("  Email     : {}", message.getEmail());
        log.info("  Details   : {}", message.getDetails());
        log.info("  Timestamp : {}", message.getTimestamp());
        log.info("==================================================");

        // Send welcome email via SMTP
        String subject = "Welcome to Fundoo Notes!";
        String body = "Hello,\n\nYour account (" + message.getEmail() + ") has been successfully registered.\n\nBest regards,\nFundoo Notes Team";
        emailService.sendSimpleEmail(message.getEmail(), subject, body);
    }

    @RabbitListener(queues = RabbitMQConfig.LOGIN_QUEUE)
    public void onUserLoggedIn(AuthEventMessage message) {
        log.info("==================================================");
        log.info("[RabbitMQ CONSUMER] User Login Event Received");
        log.info("  Email     : {}", message.getEmail());
        log.info("  Details   : {}", message.getDetails());
        log.info("  Timestamp : {}", message.getTimestamp());
        log.info("==================================================");
    }

    @RabbitListener(queues = RabbitMQConfig.FORGOT_PASSWORD_QUEUE)
    public void onForgotPassword(AuthEventMessage message) {
        log.info("==================================================");
        log.info("[RabbitMQ CONSUMER] Forgot Password Event Received");
        log.info("  Email     : {}", message.getEmail());
        log.info("  Details   : {}", message.getDetails());
        log.info("  Timestamp : {}", message.getTimestamp());
        log.info("==================================================");

        // Send password reset email via SMTP
        String subject = "Fundoo Notes - Password Reset Request";
        String body = "Hello,\n\nYou requested a password reset. " + message.getDetails() + "\n\nUse this token to reset your password.\n\nBest regards,\nFundoo Notes Team";
        emailService.sendSimpleEmail(message.getEmail(), subject, body);
    }
}
