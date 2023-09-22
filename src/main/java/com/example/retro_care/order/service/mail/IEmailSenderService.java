package com.example.retro_care.order.service.mail;

import com.example.retro_care.order.model.EmailMessage;


public interface IEmailSenderService {
    void sendEmail(EmailMessage emailMessage);
}
