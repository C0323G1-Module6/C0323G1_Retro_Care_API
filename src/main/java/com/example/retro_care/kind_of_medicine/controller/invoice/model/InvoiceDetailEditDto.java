package com.example.retro_care.kind_of_medicine.controller.invoice.model;

import com.example.retro_care.medicine.model.Medicine;

import java.util.Date;

public class InvoiceDetailEditDto {
    private Long id;
    private Float discount;
    private Date expiry;
    private Integer medicineQuantity;

    private String lot;

    private Boolean flagDeleted;

    private Medicine medicineId;


    private Invoice invoiceId;


    private String unit;

    public InvoiceDetailEditDto() {
    }

    public InvoiceDetailEditDto(Long id, Float discount, Date expiry, Integer medicineQuantity, String lot, Boolean flagDeleted, Medicine medicineId, Invoice invoiceId, String unit) {
        this.id = id;
        this.discount = discount;
        this.expiry = expiry;
        this.medicineQuantity = medicineQuantity;
        this.lot = lot;
        this.flagDeleted = flagDeleted;
        this.medicineId = medicineId;
        this.invoiceId = invoiceId;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Integer getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Integer medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }
}
