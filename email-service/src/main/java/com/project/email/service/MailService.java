package com.project.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import java.io.InputStream;
import java.net.URISyntaxException;

@Service
public class MailService {
    Logger LOG = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String email) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Limited Expense");
        msg.setText("You have spend too much \n Please pay attention to your money");

        javaMailSender.send(msg);

    }

    public void sendEmailWithAttachment(String email) throws MessagingException, IOException, URISyntaxException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            helper.setTo(email);

            helper.setSubject("Limited Expense");

            // true = text/html
            helper.setText("You have spent too much!!!\n<h1>Please pay attention to your money!</h1>", true);

            // hard coded a file path
            InputStream inputStream = getClass().getResourceAsStream("/123.jpg");
            LOG.info(inputStream.toString());
            helper.addAttachment("123.jpg", new ByteArrayResource(inputStream.readAllBytes()));

            javaMailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}