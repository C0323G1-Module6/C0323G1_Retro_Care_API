package com.example.retro_care.medicine.dto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;


public class UnitDetailDto {
    private Long id;
    private Boolean flagDeleted;
    @Min(value = 1, message = "Tỷ lệ quy đổi không được nhỏ hơn 1")
    private Long conversionRate;
    private String conversionUnit;
    private Long medicine;
    private Long unit;

    public UnitDetailDto(Long id, Boolean flagDeleted, Long conversionRate, String conversionUnit, Long medicine, Long unit) {
        this.id = id;
        this.flagDeleted = flagDeleted;
        this.conversionRate = conversionRate;
        this.conversionUnit = conversionUnit;
        this.medicine = medicine;
        this.unit = unit;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }

    public UnitDetailDto() {
    }

    public Long getMedicine() {
        return medicine;
    }

    public void setMedicine(Long medicine) {
        this.medicine = medicine;
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

    public Long getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Long conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getConversionUnit() {
        return conversionUnit;
    }

    public void setConversionUnit(String conversionUnit) {
        this.conversionUnit = conversionUnit;
    }
}
