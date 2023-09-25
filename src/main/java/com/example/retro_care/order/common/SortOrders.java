package com.example.retro_care.order.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class SortOrders {
    public static Pageable sortBy(String nameSort, int page){
        Pageable pageable;
        switch (nameSort){
            case "code":
                pageable = PageRequest.of(page, 5, Sort.by("code").ascending());
                break;
            case "nameCustomer":
                pageable = PageRequest.of(page, 5, Sort.by("nameCustomer").descending());
                break;
            case "dateTimeAsc":
                pageable = PageRequest.of(page, 5, Sort.by("orderDate").descending());
                break;
            case "dateTimeDes":
                pageable = PageRequest.of(page, 5, Sort.by("orderDate").ascending());
                break;
            case "nameEmployee":
                pageable = PageRequest.of(page, 5, Sort.by("nameEmployee").descending());
                break;
            case "orderDetailsPriceAsc":
                pageable = PageRequest.of(page, 5, Sort.by("orderDetailsPrice").ascending());
                break;
            case "orderDetailsPriceDes":
                pageable = PageRequest.of(page, 5, Sort.by("orderDetailsPrice").descending());
                break;
            default:
                pageable = PageRequest.of(page, 5, Sort.by("id").descending());
        }
        return pageable;
    }
}
