package com.example.retro_care.medicine.model;

import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;
    @JsonBackReference
    @OneToMany(mappedBy = "medicine")
    private Set<UnitDetail> unitDetailSet;
    @JsonBackReference
    @OneToMany(mappedBy = "medicine")
    private Set<ImageMedicine> imageMedicines;

    @JsonBackReference
    @OneToMany(mappedBy = "medicine")
    private Set<Indication> indicationSet;

    @ManyToOne
    @JoinColumn(name = "kind_of_medicine_id")
    private KindOfMedicine kindOfMedicine;

    public Medicine() {
    }

    public Medicine(Long id, String code, String name, Double price, Long quantity, Float vat, String note, String maker, String activeElement, String origin, Float retailProfits, Boolean flagDeleted, Set<UnitDetail> unitDetailSet, Set<ImageMedicine> imageMedicines, KindOfMedicine kindOfMedicine) {
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
        this.flagDeleted = flagDeleted;
        this.unitDetailSet = unitDetailSet;
        this.imageMedicines = imageMedicines;
        this.kindOfMedicine = kindOfMedicine;
    }

    public Medicine(Long id, String code, String name, Double price, Long quantity, Float vat, String note,
                    String maker, String activeElement, String origin, Float retailProfits, Boolean flagDeleted,
                    Set<UnitDetail> unitDetailSet, Set<ImageMedicine> imageMedicines, Set<Indication> indicationSet,
                    KindOfMedicine kindOfMedicine) {
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
        this.flagDeleted = flagDeleted;
        this.unitDetailSet = unitDetailSet;
        this.imageMedicines = imageMedicines;
        this.indicationSet = indicationSet;
        this.kindOfMedicine = kindOfMedicine;
    }

    public Medicine(Long id, String code, String name, Double price, Long quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public Boolean getFlagDeleted() {
        return this.flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Set<Indication> getIndicationSet() {
        return indicationSet;
    }

    public void setIndicationSet(Set<Indication> indicationSet) {
        this.indicationSet = indicationSet;
    }

    public KindOfMedicine getKindOfMedicine() {
        return kindOfMedicine;
    }

    public void setKindOfMedicine(KindOfMedicine kindOfMedicine) {
        this.kindOfMedicine = kindOfMedicine;
    }

}

