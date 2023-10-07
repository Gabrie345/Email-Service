package com.kipper.Emailservice.application.controller;

import com.kipper.Emailservice.application.controller.dto.EmailRequestdto;
import com.kipper.Emailservice.application.service.SenderEmailService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class SenderemailControllerTest {
    @InjectMocks
    private SenderemailController controller;
    @Mock
    private SenderEmailService senderEmailService;
    @Test
    public void testSendEmail() {
        ResponseEntity<String> stringResponseEntity = controller.sendEmail(getEmailRequestdto());
        assertEquals("Email sent", stringResponseEntity.getBody());
        assertEquals(200, stringResponseEntity.getStatusCodeValue());
    }
    @Test
    public void testSendEmailException() {
        ResponseEntity<String> stringResponseEntity = controller.sendEmail(null);
        assertEquals("Email not sent", stringResponseEntity.getBody());
        assertEquals(400, stringResponseEntity.getStatusCodeValue());
    }

    private EmailRequestdto getEmailRequestdto() {
        EmailRequestdto request = new EmailRequestdto();
        request.setTo("to");
        request.setText("text");
        request.setSubject("subject");
        return request;
    }



}