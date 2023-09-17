package com.example.retro_care.invoice.model;

import com.example.retro_care.medicine.model.Medicine;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float discount;
    private Date expiry;
    private Integer medicineQuantity;

    private String lot;

    private Boolean flagDeleted;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Medicine medicineId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Invoice invoiceId;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Long id, Float discount, Date expiry, Integer medicineQuantity, String lot, Boolean flagDeleted, Medicine medicineId, Invoice invoiceId) {
        this.id = id;
        this.discount = discount;
        this.expiry = expiry;
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

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceDetail)) return false;
        InvoiceDetail that = (InvoiceDetail) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDiscount(), that.getDiscount()) && Objects.equals(getExpiry(), that.getExpiry()) && Objects.equals(getMedicineQuantity(), that.getMedicineQuantity()) && Objects.equals(getLot(), that.getLot()) && Objects.equals(getFlagDeleted(), that.getFlagDeleted()) && Objects.equals(getMedicineId(), that.getMedicineId()) && Objects.equals(getInvoiceId(), that.getInvoiceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDiscount(), getExpiry(), getMedicineQuantity(), getLot(), getFlagDeleted(), getMedicineId(), getInvoiceId());
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", discount=" + discount +
                ", expiry=" + expiry +
                ", medicineQuantity=" + medicineQuantity +
                ", lot='" + lot + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", medicineId=" + medicineId +
                ", invoiceId=" + invoiceId +
                '}';
    }
}
