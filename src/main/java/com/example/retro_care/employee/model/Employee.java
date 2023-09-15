package com.example.retro_care.employee.model;

import com.example.retro_care.order.model.AppUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    private String nameEmployee;
    private String address;
    private String phoneNumber;
    private String startDay;
    private String birthDay;
    private String idCard;
    @Column(columnDefinition = "LONGTEXT")
    private String note;
    private boolean flagDelete;
    @ManyToOne
    private AppUser appUser;

    public Employee() {
    }

    public Employee(Long id, String code, String image, String nameEmployee, String address, String phoneNumber, String startDay, String birthDay, String idCard, String note, boolean flagDelete, AppUser appUser) {
        this.id = id;
        this.code = code;
        this.image = image;
        this.nameEmployee = nameEmployee;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.startDay = startDay;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.note = note;
        this.flagDelete = flagDelete;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
