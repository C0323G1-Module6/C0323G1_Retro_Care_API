package com.example.retro_care.prescription.dto;


import com.example.retro_care.indication.dto.IndicationDto;
import com.example.retro_care.indication.model.Indication;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;


public class PrescriptionDto implements Validator {
    private Long id;
    private String code;

    private String name;

    private String symptoms;

    private String note;
    private Integer duration;
    private Long patient;
    private List<IndicationDto> indicationDto;
    private List<Indication> indicationList;

    private Boolean flagDeleted;


    public PrescriptionDto(String code, String name, String symptoms, String note, Integer duration, Long patient, List<IndicationDto> indicationDto, Boolean flagDeleted) {
        this.code = code;
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
        this.duration = duration;
        this.patient = patient;
        this.indicationDto = indicationDto;
        this.flagDeleted = flagDeleted;
    }

    public PrescriptionDto(Long id, String code, String name, String symptoms, String note, Integer duration, Long patient, List<IndicationDto> indicationDto, Boolean flagDeleted) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
        this.duration = duration;
        this.patient = patient;
        this.indicationDto = indicationDto;
        this.flagDeleted = flagDeleted;
    }

    public List<IndicationDto> getIndicationDto() {
        return indicationDto;
    }

    public void setIndicationDto(List<IndicationDto> indicationDto) {
        this.indicationDto = indicationDto;
    }

    public PrescriptionDto() {
    }

    public Long getPatient() {
        return patient;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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

    public String getSymptoms() {
        return symptoms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PrescriptionDto prescriptionDto = (PrescriptionDto) target;


        if (prescriptionDto.name.equals("")) {
            errors.rejectValue("name", "", "Tên toa thuốc không được để trống");
        } else if (prescriptionDto.name.length() > 25) {
            errors.rejectValue("name", "", "Tên toa thuốc không được dài hơn 25 ký tự");
        }

        if (prescriptionDto.symptoms.equals("")) {
            errors.rejectValue("symptoms", "", "Triệu chứng không được để trống");
        } else if (prescriptionDto.symptoms.length() > 50) {
            errors.rejectValue("symptoms", "", "Triệu chứng không được dài quá 50 ký tự");
        }

        if (prescriptionDto.note.length() > 50) {
            errors.rejectValue("note", "", "Ghi chú không được dài quá 50 ký tự");
        }

        if (prescriptionDto.duration <= 0) {
            errors.rejectValue("duration", "", "Không được để nhỏ hơn 0");
        }
    }
}
