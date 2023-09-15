package com.example.retro_care.order.model;

import com.example.retro_care.user.model.AppUser;

import javax.persistence.*;

@Entity
public class UserOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
