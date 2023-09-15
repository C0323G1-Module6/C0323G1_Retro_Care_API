package com.example.retro_care.medicine.model;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;

import javax.persistence.*;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private Long price;
    private Long quantity;
    private Float vat;

    private String maker;
    private String origin;
    private Float retailProfits;
    private boolean flagDelete;
    @Column(columnDefinition = "LONGTEXT")
    private String activeElement;
    @ManyToOne
    private KindOfMedicine kindOfMedicine;

    public Medicine() {
    }

    public Medicine(Long id, String code, String name, Long price, Long quantity, Float vat, String maker, String origin, Float retailProfits, boolean flagDelete, String activeElement, KindOfMedicine kindOfMedicine) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.vat = vat;
        this.maker = maker;
        this.origin = origin;
        this.retailProfits = retailProfits;
        this.flagDelete = flagDelete;
        this.activeElement = activeElement;
        this.kindOfMedicine = kindOfMedicine;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Float getRetailProfits() {
        return retailProfits;
    }

    public void setRetailProfits(Float retailProfits) {
        this.retailProfits = retailProfits;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getActiveElement() {
        return activeElement;
    }

    public void setActiveElement(String activeElement) {
        this.activeElement = activeElement;
    }

    public KindOfMedicine getKindOfMedicine() {
        return kindOfMedicine;
    }

    public void setKindOfMedicine(KindOfMedicine kindOfMedicine) {
        this.kindOfMedicine = kindOfMedicine;
    }
}
