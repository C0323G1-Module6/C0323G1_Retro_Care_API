package com.example.retro_care.invoice.model;

import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.user.model.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.Set;

public class InvoiceDto {
    private Long id;
    private String code;
    private String documentNumber;
    private Date creationDate;
    private Double paid;
    private String note;
    private Boolean flagDeleted;

    private Supplier supplierId;

    private AppUser appUserId;

//    Set<InvoiceDetailDto> invoiceDetailSet;

    public InvoiceDto() {
    }

    public InvoiceDto(Long id, String code, String documentNumber, Date creationDate, Double paid, String note, Boolean flagDeleted, Supplier supplierId, AppUser appUserId) {
        this.id = id;
        this.code = code;
        this.documentNumber = documentNumber;
        this.creationDate = creationDate;
        this.paid = paid;
        this.note = note;
        this.flagDeleted = flagDeleted;
        this.supplierId = supplierId;
        this.appUserId = appUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public AppUser getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(AppUser appUserId) {
        this.appUserId = appUserId;
    }

    @Override
    public String toString() {
        return "InvoiceDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", creationDate=" + creationDate +
                ", paid=" + paid +
                ", note='" + note + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", supplierId=" + supplierId +
                ", appUserId=" + appUserId +
                '}';
    }
}
