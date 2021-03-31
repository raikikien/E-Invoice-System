package com.project.email.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.ws.rs.Path;

import com.project.email.Application;
import com.project.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    MailService mailService;

    @PostMapping(value = "/mail/send/{email}")
    public String send(@PathVariable("email") String email) throws AddressException, MessagingException, IOException, URISyntaxException {
        //mailService.sendEmail(email);
        mailService.sendEmailWithAttachment(email);
        return "Email sent successfully";
    }
}
