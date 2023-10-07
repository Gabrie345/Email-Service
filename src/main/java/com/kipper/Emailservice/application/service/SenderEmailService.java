package com.kipper.Emailservice.application.service;

import com.kipper.Emailservice.application.adapters.EmailSenderGateway;
import com.kipper.Emailservice.core.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SenderEmailService implements SendEmail {

    private final EmailSenderGateway emailSender;

    @Autowired
    public SenderEmailService(EmailSenderGateway emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String text) {
        emailSender.sendEmail(to, subject, text);
    }
}
