package com.example.retro_care.supplier.model;

public interface ISupplierProjection {
    Integer getIdSupplier();
    String getCodeSupplier();
    String getNameSupplier();
    String getPhoneNumber();
    String getAddress();
    String getNote();
    Double getDebt();
}
