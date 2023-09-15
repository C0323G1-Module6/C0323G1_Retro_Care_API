package com.example.retro_care.order.model;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private boolean flagDelete;
    private boolean flagOnline;

    public AppUser() {
    }

    public AppUser(Long id, String userName, String password, boolean flagDelete, boolean flagOnline) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.flagDelete = flagDelete;
        this.flagOnline = flagOnline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public boolean isFlagOnline() {
        return flagOnline;
    }

    public void setFlagOnline(boolean flagOnline) {
        this.flagOnline = flagOnline;
    }
}
