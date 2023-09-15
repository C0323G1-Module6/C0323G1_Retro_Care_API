package com.example.retro_care.order.model;

import javax.persistence.*;

@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
    private AppUser appUser;
    @ManyToOne
    private Orders orders;

    public UserOrder() {
    }

    public UserOrder(Long id, AppUser appUser, Orders orders) {
        this.id = id;
        this.appUser = appUser;
        this.orders = orders;
    }
}
