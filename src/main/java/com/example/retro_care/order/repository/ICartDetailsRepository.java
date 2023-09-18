package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.CartDetails;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.projection.MedicineQuantityProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICartDetailsRepository extends JpaRepository<CartDetails, Long> {


    @Modifying
    @Query(nativeQuery = true, value = "insert into cart_details (app_user_id, medicine_id, quantity)" +
            " VALUES (:appUserId, :medicineId, :newQuantity) " +
            "ON DUPLICATE KEY UPDATE quantity = quantity + :newQuantity")
    void addToCartFromDetailsAndHome(@Param("appUserId") Long appUserId,
                                     @Param("medicineId") Long medicineId, @Param("newQuantity") Integer newQuantity);




    @Modifying
    @Query(nativeQuery = true, value = "update cart_details " +
            "SET quantity = :quantity " +
            "WHERE app_user_id = :appUserId AND medicine_id = :medicineId")
    void addToCart(@Param("appUserId") Long appUserId,
                   @Param("medicineId") Long medicineId, @Param("quantity") Integer quantity);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM cart_details where app_user_id = :appUserId")
    void clearAllCartFromUser(@Param("appUserId") Long appUserId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM cart_details where id = :cartId")
    void deleteCartDetailsById(@Param("cartId") Long cartId);


    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.quantity, ud.conversion_rate "+
            "FROM medicine AS m" +
            " JOIN unit_detail AS ud ON m.id = ud.medicine_id" +
            " WHERE m.id = :medicineId")
    MedicineQuantityProjection getQuantityBasedOnUnit(@Param("medicineId") Long medicineId);

    @Query(nativeQuery = true, value = "call getCartDetailsForMail(:appUserId)")
    List<CartProjection> findCartDetailsByUserId(@Param("appUserId") Long appUserId);

}
