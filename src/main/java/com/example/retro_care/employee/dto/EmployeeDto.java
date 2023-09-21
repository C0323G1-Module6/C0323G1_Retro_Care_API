package com.example.retro_care.employee.dto;

import com.example.retro_care.customer.dto.FormatCustomer;
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
    private String appUser;


    public EmployeeDto(String codeEmployee, String nameEmployee, String address, String image, String phoneNumber, String startDay, String birthday, String idCard, String note, String appUser) {
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

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
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
        final String Name = "nameEmployee";
        if (employeeDto.getNameEmployee() == null) {
            errors.rejectValue(Name, "", "Vui lòng nhập tên");
        } else if (employeeDto.getNameEmployee().length() > 100) {
            errors.rejectValue(Name, "", "Quá ký tự cho phép");
        } else if (!employeeDto.getNameEmployee().matches("^[\\p{L}\\s]+$")) {
            errors.rejectValue(Name, "", "Tên chỉ chứa định dạng chữ");
        }
        final String ADDRESS = "address";
        if (employeeDto.getAddress() == null) {
            errors.rejectValue(ADDRESS, "", "Vui lòng nhập địa chỉ");
        } else if (employeeDto.getAddress().length() > 100) {
            errors.rejectValue(ADDRESS, "", "Địa chỉ quá ký tự cho phép");
        }
        final String PHONE_NUMBER= "phoneNumber";
        if (employeeDto.getPhoneNumber() == null) {
            errors.rejectValue(PHONE_NUMBER, "", "Vui lòng nhập số điện thoại");
        } else if (employeeDto.getPhoneNumber().length() > 11) {
            errors.rejectValue(PHONE_NUMBER, "", "Vui lòng chỉ nhập từ 10 đến 11 số");
        } else if (employeeDto.getPhoneNumber().length() <10) {
            errors.rejectValue(PHONE_NUMBER, "", "Vui lòng chỉ nhập từ 10 đến 11 số");
        } else if (!employeeDto.getPhoneNumber().matches("^0\\d{9,10}$")) {
            errors.rejectValue(PHONE_NUMBER, "", "Sai định dạng");
        }
        final String START_DAY="startDay";
        if (employeeDto.getStartDay() == null) {
            errors.rejectValue(START_DAY, "", "Vui lòng nhập ngày bắt đầu");
        } else if (!employeeDto.getStartDay().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            errors.rejectValue(START_DAY,"","Vui lòng nhập đúng định dạng yyyy-mm-dd");
        }
        final String BIRTHDAY = "birthday";
        if (employeeDto.getBirthday() == null) {
            errors.rejectValue(BIRTHDAY, "", "Vui lòng nhập ngày sinh");
        } else if (!FormatCustomer.check18YearsOld(employeeDto.getBirthday())) {
            errors.rejectValue(BIRTHDAY, "", "Nhân viên chưa đủ 18 tuổi");
        } else if (!employeeDto.getBirthday().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            errors.rejectValue(BIRTHDAY,"","Vui lòng nhập đúng định dạng yyyy-mm-dd");
        }
        final String ID_CARD="idCard";
        if (employeeDto.getIdCard() == null) {
            errors.rejectValue(ID_CARD, "", "Vui lòng nhập CCCD");
        } else if (employeeDto.getIdCard().length() > 20) {
            errors.rejectValue(ID_CARD, "", "CMND/CCCD quá ký tự cho phép");
        } else if (!employeeDto.getIdCard().matches("^\\d{9}(\\d{3})?$")) {
            errors.rejectValue(ID_CARD, "", "Sai định dạng");
        }

    }
}
