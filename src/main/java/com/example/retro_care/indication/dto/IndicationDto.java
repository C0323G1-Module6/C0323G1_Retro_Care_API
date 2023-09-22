package com.example.retro_care.indication.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class IndicationDto implements Validator {
    private Long id;
    private Integer dosage;
    private Integer frequency;
    private Boolean flagDeleted;
    private Long prescription;
    private Long medicine;

    public IndicationDto() {
    }

    public IndicationDto(Long id, Integer dosage, Integer frequency, Boolean flagDeleted, Long prescription, Long medicine) {
        this.id = id;
        this.dosage = dosage;
        this.frequency = frequency;
        this.flagDeleted = flagDeleted;
        this.prescription = prescription;
        this.medicine = medicine;
    }

    public IndicationDto(Integer dosage, Integer frequency, Boolean flagDeleted, Long prescription, Long medicine) {
        this.dosage = dosage;
        this.frequency = frequency;
        this.flagDeleted = flagDeleted;
        this.prescription = prescription;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Long getPrescription() {
        return prescription;
    }

    public void setPrescription(Long prescription) {
        this.prescription = prescription;
    }

    public Long getMedicine() {
        return medicine;
    }

    public void setMedicine(Long medicine) {
        this.medicine = medicine;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        IndicationDto indicationDto = (IndicationDto) target;

        if(indicationDto.getDosage() == null){
            errors.rejectValue("dosage","","Không được để trống");
        } else if (indicationDto.getDosage()<=0) {
            errors.rejectValue("dosage","","Không được nhỏ hơn 0");
        }

        if(indicationDto.getFrequency() == null){
            errors.rejectValue("frequency","","Không được để trống");
        } else if (indicationDto.getDosage()<=0) {
            errors.rejectValue("frequency","","Không được nhỏ hơn 0");
        }
    }
}
