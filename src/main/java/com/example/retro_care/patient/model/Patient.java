package com.example.retro_care.patient.model;

import com.example.retro_care.prescription.model.Prescription;

import javax.persistence.*;
import java.util.Set;

/*Create entity patient*/
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(255)")
    private String name;
    @Column(columnDefinition = "BIT(1)")
    private Boolean flagDeleted;
    @OneToMany(mappedBy = "patient")
    private Set<Prescription> prescriptionSet;

    public Patient() {
    }

    public Patient(Long id, String name, Boolean flagDeleted, Set<Prescription> prescriptionSet) {
        this.id = id;
        this.name = name;
        this.flagDeleted = flagDeleted;
        this.prescriptionSet = prescriptionSet;
    }

    public Patient(String name, Boolean flagDeleted, Set<Prescription> prescriptionSet) {
        this.name = name;
        this.flagDeleted = flagDeleted;
        this.prescriptionSet = prescriptionSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Set<Prescription> getPrescriptionSet() {
        return prescriptionSet;
    }

    public void setPrescriptionSet(Set<Prescription> prescriptionSet) {
        this.prescriptionSet = prescriptionSet;
    }
}
