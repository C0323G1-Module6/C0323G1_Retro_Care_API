package com.example.retro_care.prescription.dto;


import com.example.retro_care.patient.model.Patient;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;


public class PrescriptionDto implements Validator {
    private Long id;
    private String code;

    private String name;

    private String symptoms;

    private String note;
    private Integer duration;
    private Patient patient;
    private Boolean flagDeleted;

    public PrescriptionDto(String code, String name, String symptoms, String note, Integer duration, Patient patient, Boolean flagDeleted) {
        this.code = code;
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
        this.duration = duration;
        this.patient = patient;
        this.flagDeleted = flagDeleted;
    }

    public PrescriptionDto(Long id, String code, String name, String symptoms, String note, Integer duration, Patient patient, Boolean flagDeleted) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.symptoms = symptoms;
        this.note = note;
        this.duration = duration;
        this.patient = patient;
        this.flagDeleted = flagDeleted;
    }

    public PrescriptionDto() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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
        if(prescriptionDto.code.equals("")){
            errors.rejectValue("code",null,"Không được để trống mã toa thuốc");
        }else if(prescriptionDto.code.length()>=6){
            errors.rejectValue("code",null,"Độ dài mã toa thuốc không được dài hơn 6 ký tự");
        }

        if (prescriptionDto.name.equals("")){
            errors.rejectValue("name",null,"Tên toa thuốc không được để trống");
        }else if(prescriptionDto.name.length()>25){
            errors.rejectValue("name",null,"Tên toa thuốc không được dài hơn 25 ký tự");
        }

        if(prescriptionDto.symptoms.equals("")){
            errors.rejectValue("symptoms",null,"Triệu chứng không được để trống");
        } else if(prescriptionDto.symptoms.length()>50){
            errors.rejectValue("symptoms",null,"Triệu chứng không được dài quá 50 ký tự");
        }

        if(prescriptionDto.note.length()>50){
            errors.rejectValue("note",null,"Ghi chú không được dài quá 50 ký tự");
        }

        if(prescriptionDto.duration<=0){
            errors.rejectValue("duration",null,"Không được để nhỏ hơn 0");
        }
    }
}
