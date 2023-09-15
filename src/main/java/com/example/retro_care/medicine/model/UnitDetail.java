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
<<<<<<< HEAD

    @Column(name = "conversion_unit")
    private Long conversionUnit;
=======
    @Column(name = "conversion_rate")
    private Long conversionRate;

    @Column(name = "conversion_unit")
    private String conversionUnit;
>>>>>>> e5b4c5deea7d6691dfab86fd8e2fb84fd8d5c70f
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

<<<<<<< HEAD
    public UnitDetail(Long id, Boolean flagDeleted, Long conversionUnit, Medicine medicine, Unit unit) {
        this.id = id;
        this.flagDeleted = flagDeleted;
=======
    public UnitDetail(Long id, Boolean flagDeleted, Long conversionRate, String conversionUnit, Medicine medicine,
                      Unit unit) {
        this.id = id;
        this.flagDeleted = flagDeleted;
        this.conversionRate = conversionRate;
>>>>>>> e5b4c5deea7d6691dfab86fd8e2fb84fd8d5c70f
        this.conversionUnit = conversionUnit;
        this.medicine = medicine;
        this.unit = unit;
    }

<<<<<<< HEAD
=======
    public Long getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Long conversionRate) {
        this.conversionRate = conversionRate;
    }

>>>>>>> e5b4c5deea7d6691dfab86fd8e2fb84fd8d5c70f
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

<<<<<<< HEAD
    public Long getConversionUnit() {
        return this.conversionUnit;
    }

    public void setConversionUnit(Long conversionUnit) {
        this.conversionUnit = conversionUnit;
    }
}
=======
    public String getConversionUnit() {
        return this.conversionUnit;
    }

    public void setConversionUnit(String conversionUnit) {
        this.conversionUnit = conversionUnit;
    }
}
>>>>>>> e5b4c5deea7d6691dfab86fd8e2fb84fd8d5c70f
