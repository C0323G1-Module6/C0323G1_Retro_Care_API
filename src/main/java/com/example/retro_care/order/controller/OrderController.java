package com.example.retro_care.order.controller;


import com.example.retro_care.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @PostMapping()
    public ResponseEntity<?> createNewOrder(@RequestParam("appUserId") Long appUserId){
        iOrderService.createOrderForUser(appUserId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
