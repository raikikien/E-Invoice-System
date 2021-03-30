package com.project.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String email) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Limited Expense");
        msg.setText("You have spend too much \n Please pay attention to your money");

        javaMailSender.send(msg);

    }

    public void sendEmailWithAttachment(String email) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(email);

        msg.setSubject("Limited Expense");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        msg.setText("You have spend too much \n Please pay attention to your money");
        helper.setText("<h1>Check attachment for image!</h1>", true);

        // hard coded a file path
        FileSystemResource file = new FileSystemResource(new File("C:/Kien\\Invoice\\123.jpg"));

        helper.addAttachment("123.jpg", file);

        javaMailSender.send(msg);

    }

}