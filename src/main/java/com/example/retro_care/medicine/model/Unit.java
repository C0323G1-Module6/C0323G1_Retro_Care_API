package com.example.retro_care.medicine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
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
    @JsonBackReference
    @OneToMany
    private Set<UnitDetail> unitDetailSet;

    public Unit() {
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

    public Set<UnitDetail> getUnitDetailSet() {
        return unitDetailSet;
    }

    public void setUnitDetailSet(Set<UnitDetail> unitDetailSet) {
        this.unitDetailSet = unitDetailSet;
    }

    public Unit(Long id, String name, Boolean flagDeleted, Set<UnitDetail> unitDetailSet) {
        this.id = id;
        this.name = name;
        this.flagDeleted = flagDeleted;
        this.unitDetailSet = unitDetailSet;







    }
}
