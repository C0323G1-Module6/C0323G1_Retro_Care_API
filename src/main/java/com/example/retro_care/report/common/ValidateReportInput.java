package com.example.retro_care.report.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public class ValidateReportInput {

    public static Map<String, String> validate(String startDate, String endDate, String reportName, Map<String, String> errMap) {
        validateStartDate(startDate, errMap);
        validateEndDate(startDate, endDate, errMap);
        return errMap;

    }


    public static void validateStartDate(String startDate, Map<String, String> errMap) {
        if (startDate == null || startDate.trim().equals("")) {
            errMap.put("startDate", "Vui lòng chọn ngày bắt đầu");
        } else if (!isValidDateFormat(startDate)) {
            errMap.put("startDate", "Nhập sai định dạng ngày bắt đầu");
        } else if (isAfterPresentDate(startDate)) {
            errMap.put("startDate", "Ngày bắt đầu vượt quá ngày hiện tại");
        }

    }

    public static void validateEndDate(String startDate, String endDate, Map<String, String> errMap) {
        if (endDate == null || endDate.trim().equals("")) {
            errMap.put("endDate", "Vui lòng chọn ngày kết thúc");
        } else if (!isValidDateFormat(endDate)) {
            errMap.put("endDate", "Nhập sai định dạng ngày bắt đầu");
        } else if (isAfterPresentDate(endDate)) {
            errMap.put("endDate", "Ngày kết thúc vượt quá ngày hiện tại");
        } else if (isBeforeStartDate(startDate, endDate)) {
            errMap.put("endDate", "Ngày kết thúc sớm hơn ngày bắt đầu");
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
        if (days < 0) {
            return true;
        }
        return false;
    }

    public static boolean isBeforeStartDate(String startDate, String endDate) {
        LocalDate beginDate = LocalDate.parse(startDate);
        LocalDate finishDate = LocalDate.parse(endDate);
        Period startAndEndPeriod = Period.between(beginDate, finishDate);
        int startAndEndDays = startAndEndPeriod.getDays();
        if (startAndEndDays < 0) {
            return true;
        }
        return false;
    }


}
