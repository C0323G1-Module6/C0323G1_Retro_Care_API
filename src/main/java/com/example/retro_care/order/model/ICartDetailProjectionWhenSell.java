package com.example.retro_care.order.model;

public interface ICartDetailProjectionWhenSell {
    Long getCd_Id();
    Long getCd_quantity();
    Long getM_id();
    String getName();
    String getCode();
    Double getPrice();
    Long getM_quantity();
}
