package com.example.retro_care.customer.model;

import com.example.retro_care.order.model.AppUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    private String nameCustomer;
    private String address;
    private String phoneNumber;
    private String birthDay;
    private Long point;
    @Column(columnDefinition = "LONGTEXT")
    private String note;
    private boolean flagDelete;
    @ManyToOne
    private AppUser appUser;

    public Customer() {
    }

    public Customer(Long id, String code, String nameCustomer, String address, String phoneNumber, String birthDay, Long point, String note, boolean flagDelete, AppUser appUser) {
        this.id = id;
        this.code = code;
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.point = point;
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

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
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
