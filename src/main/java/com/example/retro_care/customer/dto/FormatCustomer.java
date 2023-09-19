package com.example.retro_care.customer.dto;

import com.example.retro_care.customer.service.CustomerService;
import com.example.retro_care.customer.service.ICustomerService;

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
        ICustomerService customerService = new CustomerService();
        int randomNumber = random.nextInt(10000); // Giới hạn số ngẫu nhiên trong khoảng từ 0 đến 9999
        return "KH-" + randomNumber;
    }
    /**
     * Author: TinDT
     * Goal:  Check if the date format is 18 years old or not
     */
    public static boolean check18YearsOld(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển đổi chuỗi thời gian thành LocalDate
        LocalDate date = LocalDate.parse(dateStr, formatter);

        // Trừ đi 18 năm từ ngày hiện tại
        LocalDate date18YearsAgo = currentDate.minusYears(18);
        // So sánh ngày tháng năm 18 năm trước
        return date.isBefore(date18YearsAgo);
    }
    /**
     * Author: TinDT
     * Goal:  Check the validity of the date
     */
    public static boolean isDateValidAndBeforeCurrent(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển đổi chuỗi thời gian thành LocalDate
        LocalDate date = LocalDate.parse(dateStr, formatter);

        // Kiểm tra xem thời gian có vượt quá thời gian hiện tại không
        if (date.isAfter(currentDate)) {
            return false;
        }

        return true;
    }

}
