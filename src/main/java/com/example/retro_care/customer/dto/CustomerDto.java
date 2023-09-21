package com.example.retro_care.customer.dto;
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
    private static final String NAME_DTO = "name";
    private static final String BIRTHDAY_DTO = "birthday";
    private static final String ADDRESS_DTO = "address";
    private static final String PHONE_DTO = "phoneNumber";
    private static final String EMAIL_DTO = "email";
    private static final String NOTE_DTO = "note";
    private static final String CODE_DTO = "code";
    private static final String NAME_REGEX = "^[a-zA-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$";
    private static final String BIRTHDAY_REGEX  = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
    private static final String PHONE_REGEX  = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    private static final String EMAIL_REGEX  = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String CODE_REGEX  = "^KH\\d+$";

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
        if (customerDto.getName() == null) {
            errors.rejectValue(NAME_DTO, "", "Vui lòng bổ sung tên khách hàng!");
        } else if (customerDto.getName().trim().equals("")) {
            errors.rejectValue(NAME_DTO, "", "Không được để trống tên!");
        } else if (customerDto.getName().length() < 2) {
            errors.rejectValue(NAME_DTO, "", "Tên nhập vào không đủ độ dài cho phép");
        } else if (customerDto.getName().length() > 50) {
            errors.rejectValue(NAME_DTO, "", "Tên quá dài! Không nhập quá 50 ký tự!");
        } else if (!customerDto.getName().matches(NAME_REGEX)) {
            errors.rejectValue(NAME_DTO, "", "Tên không được chứa ký tự đặc biệt!");
        }
        //Check address
        if (customerDto.getAddress() == null) {
            errors.rejectValue(ADDRESS_DTO, "", "Vui lòng bổ sung địa chỉ khách hàng!");
        } else if (customerDto.getAddress().trim().equals("")) {
            errors.rejectValue(ADDRESS_DTO, "", "Không được để trống địa chỉ!");
        } else if (customerDto.getAddress().length() < 7) {
            errors.rejectValue(ADDRESS_DTO, "", "Địa chỉ nhập vào không đủ độ dài cho phép!");
        } else if (customerDto.getAddress().length() > 100) {
            errors.rejectValue(ADDRESS_DTO, "", "Địa chỉ quá dài! Không nhập quá 100 ký tự!");
        }
        // Check birthday
        if (customerDto.getBirthday() == null) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Vui lòng bổ sung  ngày sinh khách hàng!");
        } else if (customerDto.getBirthday().trim().equals("")) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Không để trống ngày sinh khách hàng!");
        } else if (!customerDto.getBirthday().matches(BIRTHDAY_REGEX)) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Nhập không đúng định dạng ngày sinh !");
        } else if (!FormatCustomer.isDateValidAndBeforeCurrent(customerDto.getBirthday())) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Vượt quá thời gian thực tế !");
        }else if (!FormatCustomer.check18YearsOld(customerDto.getBirthday())) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Cảnh báo chưa đủ 18 tuổi !");
        }
//
        // Check number phone
        if (customerDto.getPhoneNumber() == null) {
            errors.rejectValue(PHONE_DTO, "", "Vui lòng bổ sung số điện thoại");
        } else if (customerDto.getPhoneNumber().trim().equals("")) {
            errors.rejectValue(PHONE_DTO, "", "Không được để trống số điện thoại");
        } else if (customerDto.getPhoneNumber().length() < 10) {
            errors.rejectValue(PHONE_DTO, "", "Không đúng độ dài ký tự cho phép ");
        } else if (customerDto.getPhoneNumber().length() > 11) {
            errors.rejectValue(PHONE_DTO, "", "Số điện thoại quá ký tự cho phép");
        } else if (!customerDto.getPhoneNumber().matches(PHONE_REGEX)) {
            errors.rejectValue(PHONE_DTO, "", "Bạn nhập sai định dạng số điện thoại!");
        }
        // Check email
        if (customerDto.getEmail() == null) {
            errors.rejectValue(EMAIL_DTO, "", "Vui lòng bổ sung email khách hàng");
        } else if (customerDto.getEmail().trim().equals("")) {
            errors.rejectValue(EMAIL_DTO, "", "Không được để trống email");
        } else if (customerDto.getEmail().length() > 50) {
            errors.rejectValue(EMAIL_DTO, "", "Email vượt quá ký tự cho phép");
        } else if (!customerDto.getEmail().matches(EMAIL_REGEX)) {
            errors.rejectValue(EMAIL_DTO, "", "Bạn nhập sai định dạng email!");
        }

        // Check note
        if (customerDto.getNote().length() > 100) {
            errors.rejectValue(NOTE_DTO, "", "Ghi chú vượt quá ký tự cho phép");
        }
        // Check code
        if (customerDto.getCode() == null) {
            errors.rejectValue(CODE_DTO, "", "Lỗi không tìm thấy mã code");
        } else if (customerDto.getCode().equals("")) {
            errors.rejectValue(CODE_DTO, "", "Lỗi mã code không có");
        } else if (customerDto.getCode().length() > 10000) {
            errors.rejectValue(CODE_DTO, "", "Mã code quá ký tự cho phép");
        } else if (customerDto.getCode().length() < 4) {
            errors.rejectValue(CODE_DTO, "", "Mã code không đủ độ dài cho phép");
        } else if (!customerDto.getCode().matches(CODE_REGEX)) {
            errors.rejectValue(CODE_DTO, "", "Mã code không đúng định dạng");
        }

    }


}
