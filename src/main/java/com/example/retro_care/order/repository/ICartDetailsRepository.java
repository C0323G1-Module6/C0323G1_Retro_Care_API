package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICartDetailsRepository extends JpaRepository<CartDetails, Long> {
//    @Query(nativeQuery = true, value = "INSERT INTO cart_details (app_user_id, medicine_id, quantity) \n" +
//            "VALUES (:appUserId, :medicineId, :quantity)\n" +
//            "ON DUPLICATE KEY UPDATE quantity = quantity + VALUES(quantity);")
//    void addToCartFromDetails(@Param("appUserIid") Long appUserId, @Param("medicineId") Long medicineId, @Param("quantity") Integer quantity);
//
//    @Query(nativeQuery = true, value = "UPDATE cart_details \n" +
//            "SET quantity = :quantity\n" +
//            "WHERE app_user_id = :appUserId AND medicine_id = :medicineId;")
//    void addToCart(@Param("appUserIid") Long appUserId, @Param("medicineId") Long medicineId, @Param("quantity") Integer quantity);
//
//    @Query()
//    void clearAllCart(@Param("appUserId") Long appUserId);
}
