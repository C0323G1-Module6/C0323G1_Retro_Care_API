package com.example.retro_care.order.model;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.user.model.AppUser;

import javax.persistence.*;

@Entity
public class CartDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Medicine medicine;

    private Integer quantity;

    public CartDetails() {
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
