package com.example.retro_care.order.service;


public interface ICartDetailsService {

    void addToCartFromDetails(Long appUserId, Long medicineId, Integer quantity);
}
