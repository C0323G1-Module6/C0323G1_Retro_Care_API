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
    private String conversionUnit;
    @Column(name = "conversion_rate")
    private Long conversionRate;

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

    public UnitDetail(Long id, Boolean flagDeleted, String conversionUnit, Long conversionRate, Medicine medicine, Unit unit) {
        this.id = id;
        this.flagDeleted = flagDeleted;
        this.conversionUnit = conversionUnit;
        this.conversionRate = conversionRate;
        this.medicine = medicine;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public String getConversionUnit() {
        return conversionUnit;
    }

    public void setConversionUnit(String conversionUnit) {
        this.conversionUnit = conversionUnit;
    }

    public Long getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Long conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}

