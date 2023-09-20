package com.example.retro_care.prescription.model;

import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.patient.model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

/*
 *
 * create entity Prescription
 */
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(6)")
    private String code;
    @Column(columnDefinition = "varchar(25)")
    private String name;
    @Column(columnDefinition = "varchar(50)")
    private String symptoms;
    @Column(columnDefinition = "varchar(50)")
    private String note;
    private Integer duration;
    private Boolean flagDeleted;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToMany(mappedBy = "prescription")
    @JsonBackReference
    private Set<Indication> indicationSet;

    public Prescription() {
    }

    public Prescription(Long id, String code, String name, String symptoms, String note, Integer duration, Boolean flagDeleted, Patient patient) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
        this.duration = duration;
        this.flagDeleted = flagDeleted;
        this.patient = patient;
    }

    public Prescription(String code, String name, String symptoms, String note, Integer duration, Boolean flagDeleted, Patient patient) {
        this.code = code;
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
        this.duration = duration;
        this.flagDeleted = flagDeleted;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public Set<Indication> getIndicationSet() {
        return indicationSet;
    }

    public void setIndicationSet(Set<Indication> indicationSet) {
        this.indicationSet = indicationSet;
    }

    public Prescription(Long id, String code, String name, String symptoms, String note, Integer duration, Boolean flagDeleted, Patient patient, Set<Indication> indicationSet) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
        this.duration = duration;
        this.flagDeleted = flagDeleted;
        this.patient = patient;
        this.indicationSet = indicationSet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", note='" + note + '\'' +
                ", duration=" + duration +
                ", flagDeleted=" + flagDeleted +
                ", patient=" + patient +
                ", indicationSet=" + indicationSet +
                '}';
    }
}
