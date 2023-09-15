package com.example.retro_care.medicine.model;

import javax.persistence.*;

@Entity
@Table(name = "unit_detail")
public class UnitDetail {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;

    @Column(name = "conversion_unit")
    private Long conversionUnit;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    public UnitDetail() {
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public UnitDetail(Long id, Boolean flagDeleted, Long conversionUnit, Medicine medicine, Unit unit) {
        this.id = id;
        this.flagDeleted = flagDeleted;
        this.conversionUnit = conversionUnit;
        this.medicine = medicine;
        this.unit = unit;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFlagDeleted() {
        return this.flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Long getConversionUnit() {
        return this.conversionUnit;
    }

    public void setConversionUnit(Long conversionUnit) {
        this.conversionUnit = conversionUnit;
    }
}