package com.example.retro_care.kind_of_medicine.model;
import javax.persistence.*;


@Entity
public class KindOfMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private  String name;
    private Boolean flagDeleted;

    public KindOfMedicine() {
    }

    public KindOfMedicine(String code, String name, Boolean flagDeleted) {
        this.code = code;
        this.name = name;
        this.flagDeleted = flagDeleted;
    }

    public KindOfMedicine(Long id, String code, String name, Boolean flagDeleted) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.flagDeleted = flagDeleted;
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

    @Override
    public String toString() {
        return "KindOfMedicine{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", flagDeleted=" + flagDeleted +
                '}';
    }
}
