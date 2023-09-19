package com.example.retro_care.customer.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.time.format.DateTimeFormatter;

/**
 * Author: TinDT
 * Goal:  The class includes methods to manipulate the customer format
 */
public class FormatCustomer {
    /**
     * Author: TinDT
     * Goal:  Create an automatic format for customers
     */
    public static String generateCustomerCode() {
        // Tạo một dãy số bất kỳ
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Giới hạn số ngẫu nhiên trong khoảng từ 0 đến 9999
        return "KH-" + randomNumber;
    }
    /**
     * Author: TinDT
     * Goal:  Check if the date format is 18 years old or not
     */
    public static boolean check18YearsOld(String dateStr) {
        // Định dạng ngày tháng
        LocalDate currentDate = LocalDate.now();

        // Chuyển đổi chuỗi ngày tháng thành LocalDate
        LocalDate inputDate = LocalDate.parse(dateStr);

        // Trừ đi 18 năm từ ngày hiện tại
        LocalDate date18YearsAgo = currentDate.minusYears(18);
        // So sánh ngày tháng năm 18 năm trước
        return inputDate.isBefore(date18YearsAgo);
    }
    /**
     * Author: TinDT
     * Goal:  Check the validity of the date
     */
    public static boolean isDateValidAndBeforeCurrent(String dateStr) {

        // Lấy ngày tháng năm hiện tại
        LocalDate currentDate = LocalDate.now();

        // Chuyển đổi chuỗi ngày tháng thành LocalDate
        LocalDate inputDate = LocalDate.parse(dateStr);

        // So sánh ngày tháng năm hiện tại và ngày tháng năm từ chuỗi đầu vào
        return inputDate.isBefore(currentDate);
    }
}
