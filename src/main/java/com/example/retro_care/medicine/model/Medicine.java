package com.example.retro_care.medicine.model;

import javax.persistence.*;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private Double price;
    private Long quantity;
    private Float vat;
    @Column(columnDefinition = "LONGTEXT")
    private String note;
    private String make;
    private String origin;
    private Float retail_profits;
    @Column(columnDefinition = "TEXT")
    private String active_element;
    private Boolean flag_deleted;
}
