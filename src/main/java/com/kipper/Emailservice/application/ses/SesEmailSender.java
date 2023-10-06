package com.kipper.Emailservice.application.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.kipper.Emailservice.application.adapters.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    @Override
    public void sendEmail(String to, String subject, String text) {
        SendEmailRequest emailRequest = new SendEmailRequest()
                .withSource("gabriel345wp@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(text)))
                );
        try{
            amazonSimpleEmailService.sendEmail(emailRequest);
            System.out.println("Email sent");

        }catch (Exception e){
            System.out.println("Email not sent");
            throw new RuntimeException(e);
        }
    }
}
