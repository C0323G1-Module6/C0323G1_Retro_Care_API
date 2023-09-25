package com.example.retro_care.order.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderDto {
    private static final String START_DATE = "startDateTime";
    private static final String END_DATE = "endDateTime";
    public static Map<String,String> validateOrder(String startDateTime, String endDateTime) {
       Map<String,String> errMap= new HashMap<>();
       if (startDateTime.equals("")||endDateTime.equals("")){
           return errMap;
       }
        LocalDateTime presentDate = LocalDateTime.now();
        LocalDateTime beginDate = LocalDateTime.parse(startDateTime);
        if (beginDate.isAfter(presentDate)) {
            errMap.put(START_DATE, "Ngày bắt đầu vượt quá ngày hiện tại");
        }

        LocalDateTime finishDate = LocalDateTime.parse(endDateTime);
        if (finishDate.isAfter(presentDate)) {
            errMap.put(END_DATE,  "Ngày kết thúc vượt quá ngày hiện tại");
        } else {
            LocalDateTime beginningDate = LocalDateTime.parse(startDateTime);
            LocalDateTime endingDate = LocalDateTime.parse(endDateTime);
            if (endingDate.isBefore(beginningDate)) {
                errMap.put(END_DATE, "Ngày kết thúc sớm hơn ngày bắt đầu");
            }
        }
    return errMap;
    }
}
