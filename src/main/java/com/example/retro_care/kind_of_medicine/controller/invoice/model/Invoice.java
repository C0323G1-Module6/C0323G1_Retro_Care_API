package com.example.retro_care.kind_of_medicine.controller.invoice.model;

import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.user.model.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String documentNumber;
    private Date creationDate;
    private Double paid;
    private String note;
    private Boolean flagDeleted;
    @ManyToOne
//    @JoinColumn(referencedColumnName = "id")
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplierId;
    @ManyToOne
//    @JoinColumn(referencedColumnName = "id")
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUserId;


    @OneToMany(mappedBy = "invoiceId")
    @JsonBackReference
    Set<InvoiceDetail> invoiceDetailSet;

    public Invoice() {
    }

    public Invoice(String code, String documentNumber, Date creationDate, Double paid, String note, Boolean flagDeleted, Supplier supplierId, AppUser appUserId, Set<InvoiceDetail> invoiceDetailSet) {
        this.code = code;
        this.documentNumber = documentNumber;
        this.creationDate = creationDate;
        this.paid = paid;
        this.note = note;
        this.flagDeleted = flagDeleted;
        this.supplierId = supplierId;
        this.appUserId = appUserId;
        this.invoiceDetailSet = invoiceDetailSet;
    }

    public Invoice(Long id, String code, String documentNumber, Date creationDate, Double paid, String note, Boolean flagDeleted, Supplier supplierId, AppUser appUserId, Set<InvoiceDetail> invoiceDetailSet) {
        this.id = id;
        this.code = code;
        this.documentNumber = documentNumber;
        this.creationDate = creationDate;
        this.paid = paid;
        this.note = note;
        this.flagDeleted = flagDeleted;
        this.supplierId = supplierId;
        this.appUserId = appUserId;
        this.invoiceDetailSet = invoiceDetailSet;
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

    public Set<InvoiceDetail> getInvoiceDetailSet() {
        return invoiceDetailSet;
    }

    public void setInvoiceDetailSet(Set<InvoiceDetail> invoiceDetailSet) {
        this.invoiceDetailSet = invoiceDetailSet;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", creationDate=" + creationDate +
                ", paid=" + paid +
                ", note='" + note + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", supplierId=" + supplierId +
                ", appUserId=" + appUserId +
                ", invoiceDetailSet=" + invoiceDetailSet +
                '}';
    }
}
