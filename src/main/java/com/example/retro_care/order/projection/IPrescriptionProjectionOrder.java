package com.example.retro_care.order.projection;

public interface IPrescriptionProjectionOrder {
    Long getId();
    String getCode();
    String getName();
    String getSymptoms();
    String getPatient_name();
    String getNote();
}
