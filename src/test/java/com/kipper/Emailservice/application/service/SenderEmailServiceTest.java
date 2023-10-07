package com.kipper.Emailservice.application.service;

import com.kipper.Emailservice.application.adapters.EmailSenderGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class SenderEmailServiceTest {

    @Mock
    private SenderEmailService senderEmailService;

    @Mock
    private EmailSenderGateway emailSender;

    @BeforeEach
    public void setup() {
        senderEmailService = new SenderEmailService(emailSender);
    }
    @Test
    public void sendEmail() {
        String to = "recipient@example.com";
        String subject = "Test Subject";
        String text = "Test Email Text";
        senderEmailService.sendEmail(to, subject, text);
        Mockito.verify(emailSender).sendEmail(to, subject, text);
    }

}