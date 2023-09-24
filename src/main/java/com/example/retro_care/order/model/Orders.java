package com.example.retro_care.order.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Column(columnDefinition = "datetime")
    private LocalDateTime dateTime;

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;

    private String  note;

    public Orders() {
    }

    public Orders(Long id, String code, LocalDateTime dateTime, Boolean flagDeleted, String note) {
        this.id = id;
        this.code = code;
        this.dateTime = dateTime;
        this.flagDeleted = flagDeleted;
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
