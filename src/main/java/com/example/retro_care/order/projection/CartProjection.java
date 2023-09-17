package com.example.retro_care.order.projection;

public interface CartProjection {
        Long getCartId();
        Long getMedicineId();
        String getCustomerEmail();
        String getMedicineName();
        String getMedicineImage();
        Double getMedicinePrice();
        Integer getQuantityInCart();
        String getCustomerName();
        String getAddress();
        Long getLoyaltyPoint();
}


