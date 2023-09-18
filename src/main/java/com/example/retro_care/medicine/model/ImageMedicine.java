package com.example.retro_care.medicine.model;

import javax.persistence.*;

@Entity
@Table(name = "image_medicine")
public class ImageMedicine {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "image_path", columnDefinition = "LONGTEXT")
    private String imagePath;

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;

    public ImageMedicine() {
    }

    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public ImageMedicine(Long id, String imagePath, Boolean flagDeleted, Medicine medicine) {
        this.id = id;
        this.imagePath = imagePath;
        this.flagDeleted = flagDeleted;
        this.medicine = medicine;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getFlagDeleted() {
        return this.flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

}

