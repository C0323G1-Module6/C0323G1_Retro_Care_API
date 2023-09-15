package com.example.retro_care.order.service;

import org.springframework.data.repository.query.Param;

public interface IOrderService {
    void createOrderForUser(Long appUserId);
}
