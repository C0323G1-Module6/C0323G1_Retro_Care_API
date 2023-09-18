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
        if (validateDto.getStartDate().equals("")) {
            errors.rejectValue("startDate", null, "Vui lòng chọn ngày bắt đầu");
        } else if (validateDto.getStartDate().matches("^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$")) {
            errors.rejectValue("startDate", null, "Sai định dạng ngày/tháng/năm. Vui lòng nhập lại");
        } else {
            LocalDate startDate = LocalDate.parse(validateDto.startDate);
            Period dayPeriod = Period.between(startDate, presentDate);
            int days = dayPeriod.getDays();
            if (days > 0) {
                errors.rejectValue("startDate", null, "Ngày bắt đầu vượt quá ngày hiện tại");
            }

        }

        if (validateDto.getEndDate().equals("")) {
            errors.rejectValue("endDate", null, "Vui lòng chọn ngày bắt đầu");
        } else if (validateDto.getStartDate().matches("^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$")) {
            errors.rejectValue("endDate", null, "Sai định dạng ngày/tháng/năm. Vui lòng nhập lại");
        } else {
            LocalDate endDate = LocalDate.parse(validateDto.endDate);
            Period dayPeriod = Period.between(endDate, presentDate);
            int days = dayPeriod.getDays();
            if (days > 0) {
                errors.rejectValue("startDate", null, "Ngày kết thúc vượt quá ngày hiện tại");
            } else {
                LocalDate beginDate = LocalDate.parse(validateDto.startDate);
                LocalDate finishDate = LocalDate.parse(validateDto.endDate);
                Period startAndEndPeriod = Period.between(beginDate, finishDate);
                int startAndEndDays = startAndEndPeriod.getDays();
                if (startAndEndDays < 0) {
                    errors.rejectValue("endDate", null, "Ngày kết thúc sớm hơn ngày bắt đầu");
                }
            }

        }
    }
}
