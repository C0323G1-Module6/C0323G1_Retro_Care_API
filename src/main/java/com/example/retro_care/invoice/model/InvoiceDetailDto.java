package com.example.retro_care.invoice.model;


import java.sql.Date;

public class InvoiceDetailDto {
    private Long id;
    private Float discount;
    private Date expiry;
    private Integer medicineQuantity;

    private String lot;

    private Long medicineId;


    public InvoiceDetailDto() {
    }

    public InvoiceDetailDto(Long id, Float discount, Date expiry, Integer medicineQuantity, String lot, Long medicineId) {
        this.id = id;
        this.discount = discount;
        this.expiry = expiry;
        this.medicineQuantity = medicineQuantity;
        this.lot = lot;
        this.medicineId = medicineId;
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

    public Long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }
}
