package com.example.retro_care.report.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;


public class ValidateDto implements Validator {

    private String startDate;

    private String endDate;

    public ValidateDto() {
    }

    public ValidateDto(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidateDto validateDto = (ValidateDto) target;
        LocalDate presentDate = LocalDate.now();
        if (validateDto.getStartDate() == null) {
            errors.rejectValue("startDate", null, "Nhập sai ngày bắt đầu");
        } else if (validateDto.getStartDate().equals("")) {
            errors.rejectValue("startDate", "", "Vui lòng chọn ngày bắt đầu");
        } else if (!validateDto.getStartDate().matches("^((19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])$")) {
            errors.rejectValue("startDate", null, "Sai định dạng ngày bắt đầu. Vui lòng nhập lại");
        } else {
            LocalDate startDate = LocalDate.parse(validateDto.getStartDate());
            Period dayPeriod = Period.between(startDate, presentDate);
            int days = dayPeriod.getDays();
            if (days < 0) {
                errors.rejectValue("startDate", null, "Ngày bắt đầu vượt quá ngày hiện tại");
            }
        }
        if (validateDto.getEndDate() == null) {
            errors.rejectValue("endDate", null, "Nhập sai ngày kết thúc");
        } else if (validateDto.getEndDate().equals("")) {
            errors.rejectValue("endDate", "", "Vui lòng chọn ngày kết thúc");
        } else if (!validateDto.getEndDate().matches("^((19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])$")) {
            errors.rejectValue("endDate", null, "Sai định dạng ngày kết thúc. Vui lòng nhập lại");
        } else {
            LocalDate endDate = LocalDate.parse(validateDto.endDate);
            Period dayPeriod = Period.between(endDate, presentDate);
            int days = dayPeriod.getDays();
            if (days < 0) {
                errors.rejectValue("endDate", null, "Ngày kết thúc vượt quá ngày hiện tại");
            } else {
                if (validateDto.getStartDate() == null || validateDto.getStartDate().equals("")) {
                    errors.rejectValue("startDate", null, "Vui lòng chọn ngày bắt đầu");
                } else if (!validateDto.getStartDate().matches("^((19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])$")) {
                    errors.rejectValue("startDate", null, "Sai định dạng ngày bắt đầu. Vui lòng nhập lại");
                } else {
                    LocalDate beginDate = LocalDate.parse(validateDto.getStartDate());
                    LocalDate finishDate = LocalDate.parse(validateDto.getEndDate());
                    Period startAndEndPeriod = Period.between(beginDate, finishDate);
                    int startAndEndDays = startAndEndPeriod.getDays();
                    if (startAndEndDays < 0) {
                        errors.rejectValue("endDate", null, "Ngày kết thúc sớm hơn ngày bắt đầu");
                    }
                }
            }
        }
    }
}
