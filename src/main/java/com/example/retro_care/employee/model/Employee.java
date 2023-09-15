package com.example.retro_care.employee.model;

import com.example.retro_care.user.model.AppUser;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String code="NV001";
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String address;
    @Column(columnDefinition = "longtext")
    private String image;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phoneNumber;
    @Column(columnDefinition = "date", nullable = false)
    private String startDay;
    @Column(columnDefinition = "date", nullable = false)
    private String birthday;
    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String idCard;
    @Column(columnDefinition = "longtext")
    private String note;
    @Column(columnDefinition = "bit(1) default 1")
    private boolean flagDelete;
    @OneToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    private AppUser appUser;

    public Employee(String code, String name, String address, String image, String phoneNumber, String startDay, String birthday, String idCard, String note, AppUser appUser) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.startDay = startDay;
        this.birthday = birthday;
        this.idCard = idCard;
        this.note = note;
        this.appUser = appUser;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
