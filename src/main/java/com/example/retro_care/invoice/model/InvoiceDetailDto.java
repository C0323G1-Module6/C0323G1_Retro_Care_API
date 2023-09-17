package com.example.retro_care.invoice.model;

import com.example.retro_care.medicine.model.Medicine;

import javax.persistence.*;

public class InvoiceDetailDto {

    private Long id;


    private Float discount;

    private Integer medicineQuantity;

    private String lot;

    private Boolean flagDeleted;


    private Medicine medicineId;


    private Invoice invoiceId;

    public InvoiceDetailDto() {
    }

    public InvoiceDetailDto(Long id, Float discount, Integer medicineQuantity, String lot, Boolean flagDeleted, Medicine medicineId, Invoice invoiceId) {
        this.id = id;
        this.discount = discount;
        this.medicineQuantity = medicineQuantity;
        this.lot = lot;
        this.flagDeleted = flagDeleted;
        this.medicineId = medicineId;
        this.invoiceId = invoiceId;
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

    @Override
    public String toString() {
        return "InvoiceDetailDto{" +
                "id=" + id +
                ", discount=" + discount +
                ", medicineQuantity=" + medicineQuantity +
                ", lot='" + lot + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", medicineId=" + medicineId +
                ", invoiceId=" + invoiceId +
                '}';
    }
}
