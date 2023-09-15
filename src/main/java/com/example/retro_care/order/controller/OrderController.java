package com.example.retro_care.order.controller;


import com.example.retro_care.order.model.EmailMessage;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.service.ICartDetailsService;
import com.example.retro_care.order.service.IOrderService;
import com.example.retro_care.order.service.mail.IEmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private ICartDetailsService iCartDetailsService;

    @Autowired
    private IEmailSenderService iEmailSenderService;
    @PostMapping()
    public ResponseEntity<?> createNewOrder(@RequestParam("appUserId") Long appUserId){
        iOrderService.createOrderForUser(appUserId);
        // prepare and send email
        List<CartProjection> cartsForBill = iCartDetailsService.findCartDetailsByUserId(appUserId);
        String subject = "Billing and Thank You Letter from RetroCare!";
        String message = "Hi " + cartsForBill.get(0).getCustomerEmail() + "!";
        EmailMessage emailMessage = new EmailMessage(cartsForBill.get(0).getCustomerEmail(), subject, message, cartsForBill);
        iEmailSenderService.sendEmail(emailMessage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
