package com.example.retro_care.order.projection;

public interface ICartDetailProjectionWhenSell {
    Long getCd_id();
    Long getCd_quantity();
    Long getM_id();
    String getName();
    String getCode();
    Double getPrice();
    Long getM_quantity();
    String getConversion_unit();

    Boolean getFlag_deleted();
}
