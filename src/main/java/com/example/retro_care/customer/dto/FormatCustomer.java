package com.example.retro_care.customer.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.time.format.DateTimeFormatter;


public class FormatCustomer {
    public static String generateCustomerCode() {
        // Tạo một dãy số bất kỳ
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Giới hạn số ngẫu nhiên trong khoảng từ 0 đến 9999
        return "KH-" + randomNumber;
    }
    public static boolean check18YearsOld(String dateString) {
        // Định dạng ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Chuyển đổi chuỗi ngày tháng năm thành đối tượng LocalDate
        LocalDate birthDate = LocalDate.parse(dateString, formatter);

        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();

        // Tính tuổi của người dùng
        Period age = Period.between(birthDate, currentDate);

        // Kiểm tra xem tuổi có đủ 18 tuổi hay không
        return age.getYears() >= 18;
    }
}
