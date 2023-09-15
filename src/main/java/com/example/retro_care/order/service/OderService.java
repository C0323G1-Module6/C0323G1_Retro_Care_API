package com.example.retro_care.order.service;

import com.example.retro_care.order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderService implements IOrderService{

    @Autowired
    private IOrderRepository iOrderRepository;
    @Override
    public void createOrderForUser(Long appUserId) {
        iOrderRepository.createOrderForUser(appUserId);
    }
}
