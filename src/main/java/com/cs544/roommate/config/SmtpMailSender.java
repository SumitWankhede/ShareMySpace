package com.cs544.roommate.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class SmtpMailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public  void sendMail(String to, String subject,String text) throws MessagingException{
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(text);

        javaMailSender.send(message);
    }
}
