package com.example.retro_care.customer.dto;

import com.example.retro_care.user.model.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerDto implements Validator {
    private Long id;
    private String code ;
    private String name;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String email;
    private Long point;
    private String note;
    private Boolean flagDeleted = true;
    private AppUser appUser;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String code, String name, String birthday, String address, String phoneNumber, String email, Long point, String note, Boolean flagDeleted, AppUser appUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.point = point;
        this.note = note;
        this.flagDeleted = flagDeleted;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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
        CustomerDto customerDto = (CustomerDto) target;
        // Check name
        if (customerDto.getName().trim().equals("")) {
            errors.rejectValue("name", null, "Không được để trống tên!");
        } else if (customerDto.getName().length() > 255) {
            errors.rejectValue("name", null, "Tên quá dài! Không nhập quá 255 ký tự!");
        } else if (!customerDto.getName().matches("^[a-zA-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$")) {
            errors.rejectValue("name", null, "Tên không được chứa ký tự đặc biệt!");
        }
        // Check birthday
        if (customerDto.getBirthday() == null) {
            errors.rejectValue("birthday", null, "Không được để trống ngày sinh!");
        }
        // Check number phone
        if (customerDto.getPhoneNumber().trim().equals("")) {
            errors.rejectValue("customerPhoneNumber", null, "Không được để trống số điện thoại");
        } else if (!customerDto.getPhoneNumber().matches("^(84|0[3|5|7|8|9])+([0-9]{8})\\b$")) {
            errors.rejectValue("customerPhoneNumber", null, "Bạn nhập sai định dạng số điện thoại!");
        }
    }
}
