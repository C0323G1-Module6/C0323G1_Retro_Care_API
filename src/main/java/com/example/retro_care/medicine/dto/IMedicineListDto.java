package com.example.retro_care.medicine.dto;

public interface IMedicineListDto {
    Long getId();
    String getCode();
    String getKindOfMedicineName();
    String getName();
    String getActiveElement();
    String getUnitName();
    Long getConversionRate();
    String getConversionUnit();
    Long getQuantity();
    Double getImportPrice();
    Double getWholesalePrice();
    Double getRetailPrice();
    Float getRetailProfits();
    Float getDiscount();
    Float getVat();
}
