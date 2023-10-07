package com.kipper.Emailservice.application.controller;


import com.kipper.Emailservice.application.controller.dto.EmailRequestdto;
import com.kipper.Emailservice.application.service.SenderEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class SenderemailController {

    private final SenderEmailService senderEmailService;

    @Autowired
    public SenderemailController(SenderEmailService senderEmailService) {
        this.senderEmailService = senderEmailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestdto request) {
        try {
            this.senderEmailService.sendEmail(
                    request.getTo(),
                    request.getText(),
                    request.getSubject());
            return ResponseEntity.ok("Email sent");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Email not sent");
        }
    }
}
