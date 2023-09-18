package com.example.retro_care.customer.dto;

import java.util.Random;

public class CreatCode {
    public static String generateCustomerCode() {
        // Tạo một dãy số bất kỳ
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Giới hạn số ngẫu nhiên trong khoảng từ 0 đến 9999
        return "KH-" + randomNumber;
    }
}
