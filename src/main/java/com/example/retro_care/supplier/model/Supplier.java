package com.example.retro_care.supplier.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idSupplier;
    private String codeSupplier;
    private String nameSupplier;
    private String emailSupplier;
    private String addressSupplier;
    private String telSupplier;
    private String noteSupplier;
    private Boolean flagDelete;

    public Supplier(Long idSupplier, String codeSupplier, String nameSupplier, String emailSupplier, String addressSupplier, String telSupplier, String noteSupplier, Boolean flagDelete) {
        this.idSupplier = idSupplier;
        this.codeSupplier = codeSupplier;
        this.nameSupplier = nameSupplier;
        this.emailSupplier = emailSupplier;
        this.addressSupplier = addressSupplier;
        this.telSupplier = telSupplier;
        this.noteSupplier = noteSupplier;
        this.flagDelete = flagDelete;
    }

    public Supplier() {
    }

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getCodeSupplier() {
        return codeSupplier;
    }

    public void setCodeSupplier(String codeSupplier) {
        this.codeSupplier = codeSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getEmailSupplier() {
        return emailSupplier;
    }

    public void setEmailSupplier(String emailSupplier) {
        this.emailSupplier = emailSupplier;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public String getTelSupplier() {
        return telSupplier;
    }

    public void setTelSupplier(String telSupplier) {
        this.telSupplier = telSupplier;
    }

    public String getNoteSupplier() {
        return noteSupplier;
    }

    public void setNoteSupplier(String noteSupplier) {
        this.noteSupplier = noteSupplier;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
