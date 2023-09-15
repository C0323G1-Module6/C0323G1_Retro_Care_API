package com.example.retro_care.kind_of_medicine.model;

import javax.persistence.*;

@Entity
@Table(name = "kindOfMedicine")
public class KindOfMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private  String name;
    private Boolean flagDeleted;

    public KindOfMedicine() {
    }

    public KindOfMedicine(int id, String code, String name, Boolean flagDeleted) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.flagDeleted = flagDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
