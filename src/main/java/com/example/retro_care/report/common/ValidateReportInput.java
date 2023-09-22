package com.example.retro_care.report.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public class ValidateReportInput {
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";

    private ValidateReportInput() {
    }

    public static Map<String, String> validate(String startDate, String endDate, Map<String, String> errMap) {
        validateStartDate(startDate, errMap);
        validateEndDate(startDate, endDate, errMap);
        return errMap;

    }


    public static void validateStartDate(String startDate, Map<String, String> errMap) {
        if (startDate == null || startDate.trim().equals("")) {
            errMap.put(START_DATE, "Vui lòng chọn ngày bắt đầu");
        } else if (!isValidDateFormat(startDate)) {
            errMap.put(START_DATE, "Nhập sai định dạng ngày bắt đầu");
        } else if (isAfterPresentDate(startDate)) {
            errMap.put(START_DATE, "Ngày bắt đầu vượt quá ngày hiện tại");
        }

    }

    public static void validateEndDate(String startDate, String endDate, Map<String, String> errMap) {
        if (endDate == null || endDate.trim().equals("")) {
            errMap.put(END_DATE, "Vui lòng chọn ngày kết thúc");
        } else if (!isValidDateFormat(endDate)) {
            errMap.put(END_DATE, "Nhập sai định dạng ngày bắt đầu");
        } else if (isAfterPresentDate(endDate)) {
            errMap.put(END_DATE, "Ngày kết thúc vượt quá ngày hiện tại");
        } else if (isBeforeStartDate(startDate, endDate)) {
            errMap.put(END_DATE, "Ngày kết thúc sớm hơn ngày bắt đầu");
        }

    }

    public static boolean isValidDateFormat(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Tắt kiểm tra linh hoạt

        try {
            dateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isAfterPresentDate(String dateString) {
        LocalDate startDate = LocalDate.parse(dateString);
        LocalDate presentDate = LocalDate.now();
        Period dayPeriod = Period.between(startDate, presentDate);
        int days = dayPeriod.getDays();
        return days < 0;
    }

    public static boolean isBeforeStartDate(String startDate, String endDate) {
        LocalDate beginDate = LocalDate.parse(startDate);
        LocalDate finishDate = LocalDate.parse(endDate);
        Period startAndEndPeriod = Period.between(beginDate, finishDate);
        int startAndEndDays = startAndEndPeriod.getDays();
        return startAndEndDays < 0;
    }


}
