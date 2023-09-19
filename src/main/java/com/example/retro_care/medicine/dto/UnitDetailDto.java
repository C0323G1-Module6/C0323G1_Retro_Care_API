package com.example.retro_care.medicine.dto;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.model.Unit;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;


public class UnitDetailDto implements Validator {
    private Long id;
    private Boolean flagDeleted;
    @Min(value = 1, message = "Tỷ lệ quy đổi không được nhỏ hơn 1")
    private Long conversionRate;
    private String conversionUnit;
    private MedicineDto medicineDto;
    private UnitDto unitDto;

    public UnitDetailDto(Long id, Boolean flagDeleted, Long conversionRate, String conversionUnit, MedicineDto medicineDto, UnitDto unitDto) {
        this.id = id;
        this.flagDeleted = flagDeleted;
        this.conversionRate = conversionRate;
        this.conversionUnit = conversionUnit;
        this.medicineDto = medicineDto;
        this.unitDto = unitDto;
    }

    public UnitDetailDto() {
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

    public MedicineDto getMedicineDto() {
        return medicineDto;
    }

    public void setMedicineDto(MedicineDto medicineDto) {
        this.medicineDto = medicineDto;
    }

    public UnitDto getUnitDto() {
        return unitDto;
    }

    public void setUnitDto(UnitDto unitDto) {
        this.unitDto = unitDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
