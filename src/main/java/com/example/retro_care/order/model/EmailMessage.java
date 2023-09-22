package com.example.retro_care.order.model;

import com.example.retro_care.order.projection.CartProjection;

import java.util.List;

public class EmailMessage {
    private String to;
    private String subject;
    private String message;

    private Long totalPrice;

    private List<CartProjection> cartProjections;

    public EmailMessage() {
    }

    public EmailMessage(String to, String subject, String message,Long totalPrice, List<CartProjection> cartProjections) {
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.totalPrice = totalPrice;
        this.cartProjections = cartProjections;

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

    public List<CartProjection> getCartProjections() {
        return cartProjections;
    }

    public void setCartProjections(List<CartProjection> cartProjections) {
        this.cartProjections = cartProjections;
    }
}