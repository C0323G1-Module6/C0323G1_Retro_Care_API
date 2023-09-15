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
    @Query(nativeQuery = true, value = "insert into cart_details (app_user_id, medicine_id, newQuantity)" +
            " VALUES (:appUserId, :medicineId, :quantity) " +
            "ON DUPLICATE KEY UPDATE quantity = quantity + VALUES(:newQuantity)")
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


    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.quantity, ud.conversion_unit "+
            "FROM medicine AS m" +
            " JOIN unit_detail AS ud ON m.id = ud.medicine_id" +
            " WHERE m.id = @medicine_id")
    MedicineQuantityProjection checkQuantityBasedOnUnit(@Param("medicineId") Long medicineId);

    @Query(nativeQuery = true, value = "SELECT c.email as customerEmail, m.name AS medicineName, " +
            "( SELECT image_path " +
            "FROM image_medicine im " +
            "WHERE im.medicine_id = m.id " +
            "ORDER BY im.id " +
            "LIMIT 1) as medicineImage, " +
            "m.price as medicinePrice, "+
            "cd.quantity AS quantityInCart, " +
            "c.name AS customerName, " +
            "c.address AS address " +
            "FROM cart_details as cd " +
            "JOIN medicine m ON cd.medicine_id = m.id_medicine " +
            "JOIN app_user au ON cd.app_user_id = au.id " +
            "JOIN customer c ON au.id = c.app_user_id " +
            "WHERE cd.app_user_id = :appUserId")
    List<CartProjection> findCartDetailsByUserId(@Param("appUserId") Long appUserId);

}
