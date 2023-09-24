package com.example.retro_care.order.projection;

public interface IIndicationProjectionOrder {
    Long getId();
    Integer getDosage();
    Integer getFrequency();

    Long getMedicine_id();

    String getName();
}
