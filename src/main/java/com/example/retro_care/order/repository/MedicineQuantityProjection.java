package com.example.retro_care.order.repository;

import org.springframework.beans.factory.annotation.Value;

public interface MedicineQuantityProjection {
    Long getId();
    String getName();
    Integer getQuantity();
    Integer getConversionUnit();

}
