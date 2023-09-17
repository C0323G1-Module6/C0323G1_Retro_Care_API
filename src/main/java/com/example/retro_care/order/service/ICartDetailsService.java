package com.example.retro_care.order.service;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.projection.MedicineQuantityProjection;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartDetailsService {
    void addToCartFromDetailsAndHome(Long appUserId, Long medicineId, Integer newQuantity);
    void addToCart(Long appUserId, Long medicineId, Integer quantity);
    void clearAllCartFromUser(Long appUserId);
    void deleteCartDetailsById(Long cartId);
    MedicineQuantityProjection checkQuantityBasedOnUnit(Long medicineId);

    List<CartProjection> findCartDetailsByUserId(Long appUserId);
}
