package com.example.retro_care.order.projection;

public interface MedicineProjection {
    Long getId();
    String getMedicine_Name();
    String getMedicine_Code();
    String getMedicine_Images();
    Double getPrice();
    String getUnit_Name();
    String getConversion_Unit();
    String getMedicine_Note();
    Long getQuantity();
    Long getConversion_Rate();
    String getKind_Of_Medicine_Name();

    String getMaker();
    String getActiveElement();
}

