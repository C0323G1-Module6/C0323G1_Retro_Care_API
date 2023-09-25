package com.example.retro_care.order.model;

import com.example.retro_care.customer.model.Customer;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.projection.MailProjection;

import java.util.List;

public class EmailMessage {
    private String to;
    private String subject;
    private String message;

    private Long totalPrice;

    private List<MailProjection> mailProjections;
    private Customer customer;

    private String orderCode;

    public EmailMessage() {
    }

    public EmailMessage(String to, String subject, String message,Long totalPrice,
                        List<MailProjection> mailProjections, Customer customer,String orderCode) {
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.totalPrice = totalPrice;
        this.mailProjections = mailProjections;
        this.customer = customer;
        this.orderCode = orderCode;

    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<MailProjection> getMailProjections() {
        return mailProjections;
    }


    public void setMailProjections(List<MailProjection> mailProjections) {
        this.mailProjections = mailProjections;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}