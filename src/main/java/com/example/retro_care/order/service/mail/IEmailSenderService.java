package com.example.retro_care.order.service.mail;

import com.example.retro_care.order.model.EmailMessage;
import com.example.retro_care.order.projection.CartProjection;

import java.util.List;

public interface IEmailSenderService {
    void sendEmail(EmailMessage emailMessage);
}
