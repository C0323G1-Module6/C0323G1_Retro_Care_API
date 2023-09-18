package com.example.retro_care.indication.dto;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.prescription.model.Prescription;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class IndicationDto implements Validator {
    private Long id;
    private Integer dosage;
    private Integer frequency;
    private Boolean flagDeleted;
    private Prescription prescription;
    private Medicine medicine;

    public IndicationDto() {
    }

    public IndicationDto(Long id, Integer dosage, Integer frequency, Boolean flagDeleted, Prescription prescription, Medicine medicine) {
        this.id = id;
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

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
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
            errors.rejectValue("dosage",null,"Không được để trống");
        } else if (indicationDto.getDosage()<=0) {
            errors.rejectValue("dosage",null,"Không được nhỏ hơn 0");
        }

        if(indicationDto.getFrequency() == null){
            errors.rejectValue("frequency",null,"Không được để trống");
        } else if (indicationDto.getDosage()<=0) {
            errors.rejectValue("frequency",null,"Không được nhỏ hơn 0");
        }
    }
}
