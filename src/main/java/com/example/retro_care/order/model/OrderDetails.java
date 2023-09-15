package com.example.retro_care.order.model;

import com.example.retro_care.medicine.model.Medicine;

import javax.persistence.*;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long currentPrice;
    private Long quantity;

    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Medicine medicine;

    public OrderDetails() {
    }

    public OrderDetails(Long id, Long currentPrice, Long quantity, Orders orders, Medicine medicine) {
        this.id = id;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
        this.orders = orders;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return orders;
    }

    public void setOrder(Orders orders) {
        this.orders = orders;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
