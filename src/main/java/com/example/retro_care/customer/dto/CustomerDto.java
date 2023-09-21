package com.example.retro_care.customer.dto;

import com.example.retro_care.customer.service.CustomerService;
import com.example.retro_care.customer.service.ICustomerService;
import com.example.retro_care.user.model.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;

/**
 * Author: TinDT
 * Goal:  The dto customer is used to capture validation
 */
public class CustomerDto implements Validator {
    private Long id;
    private String code ;
    private String name;
    private String birthday;
    private String address;
    private String phoneNumber;
    @Column(unique = true)
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
        ICustomerService customerService = new CustomerService();
        CustomerDto customerDto = (CustomerDto) target;
        // Check name
        if (customerDto.getName() == null) {
            errors.rejectValue("name", null, "Vui lòng bổ sung tên khách hàng!");
        } else if (customerDto.getName().trim().equals("")) {
            errors.rejectValue("name", null, "Không được để trống tên!");
        } else if (customerDto.getName().length() < 2) {
            errors.rejectValue("name", null, "Tên nhập vào không đủ độ dài cho phép");
        } else if (customerDto.getName().length() > 50) {
            errors.rejectValue("name", null, "Tên quá dài! Không nhập quá 50 ký tự!");
        } else if (!customerDto.getName().matches("^[a-zA-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$")) {
            errors.rejectValue("name", null, "Tên không được chứa ký tự đặc biệt!");
        }
        //Check address
        if (customerDto.getAddress() == null) {
            errors.rejectValue("address", null, "Vui lòng bổ sung địa chỉ khách hàng!");
        } else if (customerDto.getAddress().trim().equals("")) {
            errors.rejectValue("address", null, "Không được để trống địa chỉ!");
        } else if (customerDto.getAddress().length() < 7) {
            errors.rejectValue("address", null, "Địa chỉ nhập vào không đủ độ dài cho phép!");
        } else if (customerDto.getAddress().length() > 100) {
            errors.rejectValue("address", null, "Địa chỉ quá dài! Không nhập quá 100 ký tự!");
        }
        // Check birthday
        if (customerDto.getBirthday() == null) {
            errors.rejectValue("birthday", null, "Vui lòng bổ sung  ngày sinh khách hàng!");
        } else if (customerDto.getBirthday().trim().equals("")) {
            errors.rejectValue("birthday", null, "Không để trống ngày sinh khách hàng!");
        } else if (!customerDto.getBirthday().matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
            errors.rejectValue("birthday", null, "Nhập không đúng định dạng ngày sinh !");
        } else if (!FormatCustomer.isDateValidAndBeforeCurrent(customerDto.getBirthday())) {
            errors.rejectValue("birthday", null, "Vượt quá thời gian thực tế !");
        }else if (!FormatCustomer.check18YearsOld(customerDto.getBirthday())) {
            errors.rejectValue("birthday", null, "Cảnh báo chưa đủ 18 tuổi !");
        }
//
        // Check number phone
        if (customerDto.getPhoneNumber() == null) {
            errors.rejectValue("phoneNumber", null, "Vui lòng bổ sung số điện thoại");
        } else if (customerDto.getPhoneNumber().trim().equals("")) {
            errors.rejectValue("phoneNumber", null, "Không được để trống số điện thoại");
        } else if (customerDto.getPhoneNumber().length() < 10) {
            errors.rejectValue("phoneNumber", null, "Không đúng độ dài ký tự cho phép ");
        } else if (customerDto.getPhoneNumber().length() > 11) {
            errors.rejectValue("phoneNumber", null, "Quá ký tự cho phép");
        } else if (!customerDto.getPhoneNumber().matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            errors.rejectValue("phoneNumber", null, "Bạn nhập sai định dạng số điện thoại!");
        }
        // Check email
        if (customerDto.getEmail() == null) {
            errors.rejectValue("email", null, "Vui lòng bổ sung email khách hàng");
        } else if (customerDto.getEmail().trim().equals("")) {
            errors.rejectValue("email", null, "Không được để trống email");
        } else if (customerDto.getEmail().length() > 50) {
            errors.rejectValue("email", null, "Quá ký tự cho phép");
        } else if (!customerDto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            errors.rejectValue("email", null, "Bạn nhập sai định dạng email!");
        }

        // Check note
        if (customerDto.getEmail().length() > 100) {
            errors.rejectValue("note", null, "Quá ký tự cho phép");
        }
        // Check code
        if (customerDto.getCode().length() > 10000){
            errors.rejectValue("code",null,"Mã code quá ký tự cho phép");
        } else if (customerDto.getCode().length() < 4) {
            errors.rejectValue("code",null,"Mã code không đủ độ dài cho phép");
        } else if (!customerDto.getCode().matches("^KH\\d+$")) {
            errors.rejectValue("code",null,"Mã code không đúng định dạng");
        }

    }
        
        
}
