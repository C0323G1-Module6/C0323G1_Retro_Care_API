package com.example.retro_care.medicine.dto;

public interface IMedicineListDto {
    Long getId();
    String getCode();
    String getKindOfMedicineName();
    String getName();
    String getActiveElement();
    String getUnitName();
    String getConversionUnit();
    Long getQuantity();
    Float getDiscount();
    Float getVat();
}
