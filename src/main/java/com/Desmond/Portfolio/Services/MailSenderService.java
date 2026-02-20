package com.Desmond.Portfolio.Services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    private final JavaMailSender mailSender;

    public MailSenderService(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }
    public String sendMail(String from,String subject,String body){

        try {
            SimpleMailMessage message=new SimpleMailMessage();

            message.setFrom(from);
            message.setTo("mosewadesmond919@gmail.com");
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);

            return "Message sent successfully.";
        }catch (Exception e){
            return "Something went wrong :"+e.getMessage();
        }

    }
}
