package com.kipper.Emailservice.application.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String text);
}
