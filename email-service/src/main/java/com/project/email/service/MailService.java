package com.project.email.service;

import com.project.email.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private JavaMailSender javaMailSender;
    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

    }

    public void sendEmail(Mail usermodel) throws MailException {

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(usermodel.getName()).append(System.lineSeparator());
        sb.append("\n Message: ").append(usermodel.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(usermodel.getEmail());
        mail.setFrom("emailremoved@gmail.com");
        mail.setSubject(usermodel.getMessage());
        mail.setText(sb.toString());

        javaMailSender.send(mail);
    }

}