package com.example.retro_care.medicine.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ImageMedicineDto implements Validator {
    private Long id;
    private String imagePath;
    private Boolean flagDeleted;
    private Long medicine;

    public ImageMedicineDto(Long id, String imagePath, Boolean flagDeleted, Long medicine) {
        this.id = id;
        this.imagePath = imagePath;
        this.flagDeleted = flagDeleted;
        this.medicine = medicine;
    }

    public ImageMedicineDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicine() {
        return medicine;
    }

    public void setMedicine(Long medicine) {
        this.medicine = medicine;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
