package com.project.email.controller;

import com.project.email.entity.Mail;
import com.project.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail/sending")
public class EmailController {
    @Autowired
    private MailService mailService;

    //some other code

    @PostMapping()
    public ResponseEntity<Mail> SendingEmail(Mail email){
        try {
            mailService.sendEmail(email);
            return new ResponseEntity<>(email,  HttpStatus.OK);
        } catch( MailException e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}

