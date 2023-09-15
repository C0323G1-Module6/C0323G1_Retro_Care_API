package com.example.retro_care.medicine.model;


import javax.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;

    public Unit(Long id, String name, Boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.flagDeleted = flagDeleted;

    }

    public Unit() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlagDeleted() {
        return this.flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}
