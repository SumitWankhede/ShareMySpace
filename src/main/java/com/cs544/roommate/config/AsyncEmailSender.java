package com.cs544.roommate.config;

import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;

public class AsyncEmailSender {
    @Async

    public void sendEmail(SmtpMailSender propertyMailSender, SessionListener sessionListener){
        try{
            propertyMailSender.sendMail(sessionListener.getUser().getEmail(),"Property removed","Congratulations~!. Your property deleted.");
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }

}
