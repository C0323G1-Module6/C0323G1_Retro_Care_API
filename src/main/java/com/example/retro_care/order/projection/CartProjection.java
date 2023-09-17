package com.example.retro_care.order.projection;

public interface CartProjection {
        String getCustomerEmail();
        String getMedicineName();
        String getMedicineImage();
        Double getMedicinePrice();
        Integer getQuantityInCart();
        String getCustomerName();
        String getAddress();
}


