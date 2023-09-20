package com.example.retro_care.order.projection;

public interface IMedicineWhenSell {
    Long getId();
    String getCode();
    String getName();
    Double getPrice();
    Long getQuantity();
}
