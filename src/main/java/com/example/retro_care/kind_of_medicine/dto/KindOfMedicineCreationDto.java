package com.example.retro_care.kind_of_medicine.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class KindOfMedicineCreationDto implements Validator {
    private int id;
    private String code;
    private String name;

    public KindOfMedicineCreationDto() {
    }

    public KindOfMedicineCreationDto(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        KindOfMedicineCreationDto kindOfMedicineCreationDto = (KindOfMedicineCreationDto) target;
        if (!kindOfMedicineCreationDto.getName().matches("^[A-Za-z0-9\\s\\-]{1,25}$")){
            errors.rejectValue("name","name","Wrong Format");
        }
    }
}
