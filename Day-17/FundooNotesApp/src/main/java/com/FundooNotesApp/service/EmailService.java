package com.FundooNotesApp.service;

public interface EmailService {
    void sendSimpleEmail(String toEmail, String subject, String body);
}
