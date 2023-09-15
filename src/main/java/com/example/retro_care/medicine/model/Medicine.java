package com.example.retro_care.medicine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "vat")
    private Float vat;

    @Column(name = "note", columnDefinition = "LONGTEXT")
    private String note;

    @Column(name = "maker")
    private String maker;

    @Column(name = "active_element", columnDefinition = "TEXT")
    private String activeElement;

    @Column(name = "origin")
    private String origin;

    @Column(name = "retail_profits")
    private Float retailProfits;

    @Column(name = "kind_of_medicine_id")
    private Long kindOfMedicineId;

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;
    @JsonBackReference
    @OneToMany(mappedBy = "medicine")
    private Set<UnitDetail> unitDetailSet;
    @JsonBackReference
    @OneToMany(mappedBy = "medicine")
    private Set<ImageMedicine> imageMedicines;

    public Medicine() {
    }

    public Medicine(Long id, String code, String name, Double price, Long quantity, Float vat, String note, String maker,
                    String activeElement, String origin, Float retailProfits, Long kindOfMedicineId, Boolean flagDeleted,
                    Set<UnitDetail> unitDetailSet, Set<ImageMedicine> imageMedicines) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.vat = vat;
        this.note = note;
        this.maker = maker;
        this.activeElement = activeElement;
        this.origin = origin;
        this.retailProfits = retailProfits;
        this.kindOfMedicineId = kindOfMedicineId;
        this.flagDeleted = flagDeleted;
        this.unitDetailSet = unitDetailSet;
        this.imageMedicines = imageMedicines;
    }

    public Set<UnitDetail> getUnitDetailSet() {
        return unitDetailSet;
    }

    public void setUnitDetailSet(Set<UnitDetail> unitDetailSet) {
        this.unitDetailSet = unitDetailSet;
    }

    public Set<ImageMedicine> getImageMedicines() {
        return imageMedicines;
    }

    public void setImageMedicines(Set<ImageMedicine> imageMedicines) {
        this.imageMedicines = imageMedicines;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getVat() {
        return this.vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getActiveElement() {
        return this.activeElement;
    }

    public void setActiveElement(String activeElement) {
        this.activeElement = activeElement;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Float getRetailProfits() {
        return this.retailProfits;
    }

    public void setRetailProfits(Float retailProfits) {
        this.retailProfits = retailProfits;
    }

    public Long getKindOfMedicineId() {
        return this.kindOfMedicineId;
    }

    public void setKindOfMedicineId(Long kindOfMedicineId) {
        this.kindOfMedicineId = kindOfMedicineId;
    }

    public Boolean getFlagDeleted() {
        return this.flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}