package com.example.retro_care.employee.dto;

import com.example.retro_care.user.model.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class EmployeeDto implements Validator {
    private String codeEmployee;
    private String nameEmployee;
    private String address;
    private String image;
    private String phoneNumber;
    private String startDay;
    private String birthday;
    private String idCard;
    private String note;
    private AppUser appUser;

    public EmployeeDto(String codeEmployee, String nameEmployee, String address, String image, String phoneNumber, String startDay, String birthday, String idCard, String note, AppUser appUser) {
        this.codeEmployee = codeEmployee;
        this.nameEmployee = nameEmployee;
        this.address = address;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.startDay = startDay;
        this.birthday = birthday;
        this.idCard = idCard;
        this.note = note;
        this.appUser = appUser;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public EmployeeDto() {
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//    codeEmployee ,nameEmployee, address,image,phoneNumber,birthday,idCard,note,appUser
        EmployeeDto employeeDto = (EmployeeDto) target;

        if(employeeDto.getNameEmployee().trim().equals("")){
            errors.rejectValue("nameEmployee",null,"Vui lòng nhập tên");
        }else if(employeeDto.getNameEmployee().length()>100){
            errors.rejectValue("nameEmployee",null,"Quá ký tự cho phép");
        }

        if(employeeDto.getAddress().trim().equals("")){
            errors.rejectValue("address",null,"Vui lòng nhập địa chỉ");
        }else if(employeeDto.getAddress().length()>100){
            errors.rejectValue("address",null,"Quá ký tự cho phép");
        }

        if(employeeDto.getPhoneNumber().trim().equals("")){
            errors.rejectValue("address",null,"Vui lòng nhập số điện thoại");
        }else if(employeeDto.getPhoneNumber().length()>100){
            errors.rejectValue("address",null,"Quá ký tự cho phép");
        } else if (!employeeDto.getPhoneNumber().matches("^0\\d{9,10}$")) {
            errors.rejectValue("address",null,"Sai định dạng");
        }

        if(employeeDto.getStartDay().trim().equals("")){
            errors.rejectValue("startDay",null,"Vui lòng nhập ngày bắt đầu");
        }

        if(employeeDto.getBirthday().trim().equals("")){
            errors.rejectValue("birthday",null,"Vui lòng nhập ngày sinh");
        }

        if(employeeDto.getIdCard().trim().equals("")){
            errors.rejectValue("idCard",null,"Vui lòng nhập CCCD");
        }else if(employeeDto.getIdCard().length()>100){
            errors.rejectValue("idCard",null,"Quá ký tự cho phép");
        } else if (!employeeDto.getIdCard().matches("^\\d{9}(\\d{3})?$")) {
            errors.rejectValue("idCard",null,"Sai định dạng");
        }

    }
}