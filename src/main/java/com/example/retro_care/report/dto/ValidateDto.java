package com.example.retro_care.report.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;


public class ValidateDto implements Validator {

    private String startDate;

    private String endDate;
    private String reportName;

    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String REGEX = "^((19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|1\\d|2\\d|3[01])$";

    public ValidateDto() {
    }

    public ValidateDto(String startDate, String endDate, String reportName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reportName = reportName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
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
            errors.rejectValue(START_DATE, "", "Nhập sai ngày bắt đầu");
        } else if (validateDto.getStartDate().equals("")) {
            errors.rejectValue(START_DATE, "", "Vui lòng chọn ngày bắt đầu");
        } else if (!validateDto.getStartDate().matches(REGEX)) {
            errors.rejectValue(START_DATE, "", "Sai định dạng ngày bắt đầu. Vui lòng nhập lại");
        } else {
            LocalDate beginDate = LocalDate.parse(validateDto.getStartDate());
            Period dayPeriod = Period.between(beginDate, presentDate);
            int days = dayPeriod.getDays();
            if (days < 0) {
                errors.rejectValue(START_DATE, "", "Ngày bắt đầu vượt quá ngày hiện tại");
            }
        }
        if (validateDto.getEndDate() == null) {
            errors.rejectValue(END_DATE, "", "Nhập sai ngày kết thúc");
        } else if (validateDto.getEndDate().equals("")) {
            errors.rejectValue(END_DATE, "", "Vui lòng chọn ngày kết thúc");
        } else if (!validateDto.getEndDate().matches(REGEX)) {
            errors.rejectValue(END_DATE, "", "Sai định dạng ngày kết thúc. Vui lòng nhập lại");
        } else {
            LocalDate finishDate = LocalDate.parse(validateDto.endDate);
            Period dayPeriod = Period.between(finishDate, presentDate);
            int days = dayPeriod.getDays();
            if (days < 0) {
                errors.rejectValue(END_DATE, "", "Ngày kết thúc vượt quá ngày hiện tại");
            } else {
                if (validateDto.getStartDate() == null || validateDto.getStartDate().equals("")) {
                    errors.rejectValue(START_DATE, "", "Vui lòng chọn ngày bắt đầu");
                } else if (!validateDto.getStartDate().matches(REGEX)) {
                    errors.rejectValue(START_DATE, "", "Sai định dạng ngày bắt đầu. Vui lòng nhập lại");
                } else {
                    LocalDate beginingDate = LocalDate.parse(validateDto.getStartDate());
                    LocalDate finishingDate = LocalDate.parse(validateDto.getEndDate());
                    Period startAndEndPeriod = Period.between(beginingDate, finishingDate);
                    int startAndEndDays = startAndEndPeriod.getDays();
                    if (startAndEndDays < 0) {
                        errors.rejectValue(END_DATE, "", "Ngày kết thúc sớm hơn ngày bắt đầu");
                    }
                }
            }
        }
    }
}
