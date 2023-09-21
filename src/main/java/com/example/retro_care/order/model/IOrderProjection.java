package com.example.retro_care.order.model;

public interface IOrderProjection {
    String getCode();
    String getNameEmployee();
    String getNameCustomer();
    String getOrderDate();
    String getOrderTime();
    String getOrderDetailsPrice();
    String getOrderNote();
}
