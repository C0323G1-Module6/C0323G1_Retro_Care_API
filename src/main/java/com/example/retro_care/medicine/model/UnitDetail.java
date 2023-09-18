package com.example.retro_care.medicine.model;

import javax.persistence.*;

@Entity
@Table(name = "unit_detail")
public class UnitDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;
    @Column(name = "conversion_rate")
    private Long conversionRate;

    @Column(name = "conversion_unit")
    private String conversionUnit;
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

    public UnitDetail(Long id, Boolean flagDeleted, Long conversionRate, String conversionUnit, Medicine medicine,
                      Unit unit) {
        this.id = id;
        this.flagDeleted = flagDeleted;
        this.conversionRate = conversionRate;
        this.conversionUnit = conversionUnit;
        this.medicine = medicine;
        this.unit = unit;
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

    public String getConversionUnit() {
        return this.conversionUnit;
    }

    public void setConversionUnit(String conversionUnit) {
        this.conversionUnit = conversionUnit;
    }
}