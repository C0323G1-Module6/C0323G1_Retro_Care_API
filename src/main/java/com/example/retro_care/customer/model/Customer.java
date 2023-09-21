package com.example.retro_care.customer.model;

import com.example.retro_care.user.model.AppUser;

import javax.persistence.*;
/**
 * Author: TinDT & QuyenHT
 * Goal: class initializes the customer
 * return customer
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(20)", unique = true)
    private String code;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column(name = "birth_day", columnDefinition = "date")
    private String birthDay;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @Column(name = "phone_number",columnDefinition = "varchar(20)", unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "varchar(100)", unique = true)
    private String email;
    private Long point;
    @Column(columnDefinition = "text")
    private String note;
    @Column(name = "flag_deleted", columnDefinition = "bit(0)")
    private Boolean flagDeleted = false;
    @OneToOne
    @JoinColumn(name = "app_user_id ",referencedColumnName = "id",nullable = true)
    private AppUser appUser;

    public Customer() {
    }

    public Customer(Long id, String code, String name, String birthday, String address, String phoneNumber, String email, Long point, String note, Boolean flagDeleted, AppUser appUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthDay = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.point = point;
        this.note = note;
        this.flagDeleted = flagDeleted;
        this.appUser = appUser;
    }
    // HANHNLM 's constructor
    public Customer(String name, String phoneNumber, String email, String address, String note){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.note = note;
    }
    // HANHNLM 's constructor
    public Customer(Long id, String name, String phoneNumber, String email, String address, String note){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.note = note;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthDay;
    }

    public void setBirthday(String birthday) {
        this.birthDay = birthday;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", point=" + point +
                ", note='" + note + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", appUser=" + appUser +
                '}';
    }
}
