package com.example.retro_care.order.service;
import com.example.retro_care.order.repository.MedicineQuantityProjection;

public interface ICartDetailsService {
    void addToCartFromDetailsAndHome(Long appUserId, Long medicineId, Integer newQuantity);
    void addToCart(Long appUserId, Long medicineId, Integer quantity);
    void clearAllCartFromUser(Long appUserId);
    void deleteCartDetailsById(Long cartId);
    MedicineQuantityProjection checkQuantityBasedOnUnit(Long medicineId);
}
