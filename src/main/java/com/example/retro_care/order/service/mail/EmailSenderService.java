package com.example.retro_care.order.service.mail;

import com.example.retro_care.order.model.EmailMessage;
import com.example.retro_care.order.utils.OrderUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService implements IEmailSenderService {

    private final JavaMailSender mailSender;


    public EmailSenderService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }


    @Override
    public void sendEmail(EmailMessage emailMessage) {

//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom("c0323g1@gmail.com");
//        simpleMailMessage.setTo(to);
//        simpleMailMessage.setSubject(subject);
//        simpleMailMessage.setText(message);

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom("c0323g1@gmail.com");
            helper.setTo(emailMessage.getTo());
            helper.setSubject(emailMessage.getSubject());

            String tableOfProds = OrderUtils.generateHTMLForMail(emailMessage.getCartProjections());

            String htmlContent = emailMessage.getMessage() + tableOfProds;

            helper.setText(htmlContent, true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}