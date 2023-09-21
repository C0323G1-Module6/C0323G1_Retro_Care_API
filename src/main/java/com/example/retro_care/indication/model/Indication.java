package com.example.retro_care.indication.model;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.prescription.model.Prescription;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/*
* Create entity Indication
* */
@Entity
public class Indication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dosage;
    private Integer frequency;

    private Boolean flagDeleted;
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    @JsonManagedReference
    private Prescription prescription;
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    @JsonManagedReference
    private Medicine medicine;

    public Indication() {
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Indication(Long id, Integer dosage, Integer frequency, Boolean flagDeleted, Prescription prescription) {
        this.id = id;
        this.dosage = dosage;
        this.frequency = frequency;
        this.flagDeleted = flagDeleted;
        this.prescription = prescription;
    }

    public Indication(Long id, Integer dosage, Integer frequency, Boolean flagDeleted, Prescription prescription, Medicine medicine) {
        this.id = id;
        this.dosage = dosage;
        this.frequency = frequency;
        this.flagDeleted = flagDeleted;
        this.prescription = prescription;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

}
