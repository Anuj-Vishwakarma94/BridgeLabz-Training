package com.FundooNotesApp.service.impl;

import com.FundooNotesApp.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username:your_email@gmail.com}")
    private String fromEmail;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendSimpleEmail(String toEmail, String subject, String body) {
        try {
            log.info("[SMTP EmailService] Sending email to: {} | Subject: {}", toEmail, subject);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
            log.info("[SMTP EmailService] Email successfully sent to: {}", toEmail);
        } catch (Exception e) {
            log.warn("[SMTP EmailService] Failed to send email via SMTP to {}: {}", toEmail, e.getMessage());
        }
    }
}
