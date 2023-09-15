package com.example.retro_care.customer.model;

import com.example.retro_care.user.model.AppUser;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(20)")
    private String code;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column(name = "birth_day", columnDefinition = "date")
    private String birthday;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @Column(name = "phone_number",columnDefinition = "varchar(20)")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    private Long point;
    @Column(columnDefinition = "text")
    private String note;
    @Column(name = "flag_deleted", columnDefinition = "bit(1)")
    private Boolean flagDeleted = true;
    @OneToOne
    @JoinColumn(name = "app_user_id ",referencedColumnName = "id",nullable = true)
    private AppUser appUser;

    public Customer() {
    }

    public Customer(Long id, String code, String name, String birthday, String address, String phoneNumber, String email, Long point, String note, Boolean flagDeleted, AppUser appUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.point = point;
        this.note = note;
        this.flagDeleted = flagDeleted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
}
