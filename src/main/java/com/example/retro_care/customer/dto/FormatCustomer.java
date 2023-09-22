package com.example.retro_care.customer.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Author: TinDT
 * Goal:  The class includes methods to manipulate the customer format
 */
public class FormatCustomer {
    private static final Random random = new Random();

    /**
     * Author: TinDT
     * Goal:  Create an automatic format for customers
     */
    public static String generateCustomerCode() {
        int randomNumber = random.nextInt(10000);
        return "KH"+ randomNumber;
    }
    /**
     * Author: TinDT
     * Goal:  Check if the date format is 18 years old or not
     */
    public static boolean check18YearsOld(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        LocalDate date18YearsAgo = currentDate.minusYears(18);
        return date.isBefore(date18YearsAgo);
    }
    /**
     * Author: TinDT
     * Goal:  Check the validity of the date
     */
    public static boolean isDateValidAndBeforeCurrent(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
      return !date.isAfter(currentDate);
    }

}
