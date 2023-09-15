package com.example.retro_care.medicine.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
=======

import javax.persistence.*;
>>>>>>> e5b4c5deea7d6691dfab86fd8e2fb84fd8d5c70f

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
<<<<<<< HEAD
    @JsonBackReference
    @OneToMany
    private Set<UnitDetail> unitDetailSet;

    public Unit(Long id, String name, Boolean flagDeleted, Set<UnitDetail> unitDetailSet) {
        this.id = id;
        this.name = name;
        this.flagDeleted = flagDeleted;
        this.unitDetailSet = unitDetailSet;
=======

    public Unit(Long id, String name, Boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.flagDeleted = flagDeleted;

>>>>>>> e5b4c5deea7d6691dfab86fd8e2fb84fd8d5c70f
    }

    public Unit() {
    }

<<<<<<< HEAD
    public Set<UnitDetail> getUnitDetailSet() {
        return unitDetailSet;
    }

    public void setUnitDetailSet(Set<UnitDetail> unitDetailSet) {
        this.unitDetailSet = unitDetailSet;
    }

=======
>>>>>>> e5b4c5deea7d6691dfab86fd8e2fb84fd8d5c70f
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
