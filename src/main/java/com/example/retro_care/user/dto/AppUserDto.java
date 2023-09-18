package com.example.retro_care.user.dto;

import com.example.retro_care.user.common.ValidateAppUser;
import com.example.retro_care.user.model.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.OneToMany;
import java.util.Set;

/**
 * class: AppUserDto
 * Creater: NhatNHH
 * Date: 15-09-2023
 * Function: input data, output data, validate data
 */

public class AppUserDto implements Validator {

    private Long id;
    private String userName;
    private String password;
    private String confirmPassword;
    private Boolean flagDeleted;
    private Boolean flagOnline;
    private Set<UserRole> userRoleSet;

    public AppUserDto() {
    }

    public AppUserDto(Long id, String userName, String password, String confirmPassword, Boolean flagDeleted, Boolean flagOnline, Set<UserRole> userRoleSet) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.flagDeleted = flagDeleted;
        this.flagOnline = flagOnline;
        this.userRoleSet = userRoleSet;
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

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagOnline() {
        return flagOnline;
    }

    public void setFlagOnline(Boolean flagOnline) {
        this.flagOnline = flagOnline;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppUserDto appUserDto = (AppUserDto) target;
        ValidateAppUser.checkValidateAppUserName(appUserDto.getUserName(),errors);
        ValidateAppUser.checkValidateAppUserPassword(appUserDto.getPassword(),errors);
    }


}
