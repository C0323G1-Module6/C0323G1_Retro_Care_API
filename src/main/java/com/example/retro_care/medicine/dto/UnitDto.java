package com.example.retro_care.medicine.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class UnitDto {
    private Long id;
    //    @Size(max = 255, message = "Đơn vị không được vượt quá 255 kí tự")
    private String name;
    private Boolean flagDeleted;

    public UnitDto(Long id, String name, Boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.flagDeleted = flagDeleted;
    }

    public UnitDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}
