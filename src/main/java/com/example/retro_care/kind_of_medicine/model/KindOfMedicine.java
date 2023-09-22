package com.example.retro_care.kind_of_medicine.model;

import com.example.retro_care.medicine.model.Medicine;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class KindOfMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private  String name;
    private Boolean flagDeleted;

//    @JsonBackReference
    @OneToMany(mappedBy = "kindOfMedicine")
    @JsonBackReference
    private Set<Medicine> medicineSet;

    public KindOfMedicine() {
    }

    public KindOfMedicine(Long id, String code, String name, Boolean flagDeleted, Set<Medicine> medicineSet) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.flagDeleted = flagDeleted;
        this.medicineSet = medicineSet;
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

    public Set<Medicine> getMedicineSet() {
        return medicineSet;
    }

    public void setMedicineSet(Set<Medicine> medicineSet) {
        this.medicineSet = medicineSet;
    }
}
