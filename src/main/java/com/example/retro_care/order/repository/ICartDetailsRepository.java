package com.example.retro_care.order.repository;


import com.example.retro_care.order.projection.*;
import com.example.retro_care.order.model.CartDetails;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.projection.MedicineProjection;
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


    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: add product to cart on home/ details screen, if product already exists then updates quantity;
     * @param : appUserId, medicineId, newQuantity;
     */
    @Modifying
    @Query(nativeQuery = true, value = "insert into cart_details (app_user_id, medicine_id, quantity)" +
            " VALUES (:appUserId, :medicineId, :newQuantity) " +
            "ON DUPLICATE KEY UPDATE quantity = quantity + :newQuantity")
    void addToCartFromDetailsAndHome(@Param("appUserId") Long appUserId,
                                     @Param("medicineId") Long medicineId, @Param("newQuantity") Integer newQuantity);


    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: update quantity of product cart;
     * @param : appUserId, medicineId, quantity;
     */
    @Modifying
    @Query(nativeQuery = true, value = "update cart_details " +
            "SET quantity = :quantity " +
            "WHERE app_user_id = :appUserId AND medicine_id = :medicineId")
    void addToCart(@Param("appUserId") Long appUserId,
                   @Param("medicineId") Long medicineId, @Param("quantity") Integer quantity);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: clears all products in cart;
     * @param : appUserId;
     */
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM cart_details where app_user_id = :appUserId")
    int clearAllCartFromUser(@Param("appUserId") Long appUserId);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: delete a specific product in cart;
     * @param : cartId;
     */
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM cart_details where id = :cartId")
    int deleteCartDetailsById(@Param("cartId") Long cartId);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: gets all needed info of a product;
     * @param : medicineId;
     * @return : MedicineProjection that holds all info of product;
     */
    @Query(nativeQuery = true, value = "SELECT " +
            "m.id,"+
            "ud.conversion_rate,"+
            "m.name AS medicine_name," +
            "m.code AS medicine_code," +
            "GROUP_CONCAT(im.image_path) AS medicine_images," +
            "m.price AS price," +
            "u.name AS unit_name," +
            "ud.conversion_unit AS conversion_unit," +
            "m.note AS medicine_note," +
            "m.quantity AS quantity," +
            "km.name AS kind_of_medicine_name " +
            "FROM medicine m " +
            "JOIN kind_of_medicine km ON m.kind_of_medicine_id = km.id " +
            "LEFT JOIN image_medicine im ON m.id = im.medicine_id " +
            "LEFT JOIN unit_detail ud ON m.id = ud.medicine_id " +
            "LEFT JOIN unit u ON ud.unit_id = u.id "+
            "WHERE m.id = :medicineId " +
            "GROUP BY m.id")
    MedicineProjection getMedicine(@Param("medicineId") Long medicineId);


    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get product and customer's info for display and mailing purpose;
     * @param : appUserId;
     * @return : list of CartProjection that holds some info of product,
     * as well as customer for display and mailing purpose;
     */
    @Query(nativeQuery = true, value = "call getCartDetailsForMail(:appUserId)")
    List<CartProjection> findCartDetailsByUserId(@Param("appUserId") Long appUserId);


    /**

     * author: VuNL
     * date create: 16/09/2023
     * function: find medicine when sell offline
     *
     * @param name
     * @return List medicine
     */
    @Query(nativeQuery = true, value = "select id, code, name, price, quantity from medicine " +
            "where name like :name% and flag_deleted = false")
    List<IMedicineWhenSell> getMedicineByNameWhenSell(@Param("name") String name);

    /**
     * author: VuNL
     * date create: 16/09/2023
     * function: get all cart of employee when sell
     * @param id
     * @return List cart when sell
     */
    @Query(nativeQuery = true, value = "select c.id as cd_id, c.quantity as cd_quantity, m.id as m_id," +
            " m.name, m.code, m.price, m.quantity as m_quantity, u.conversion_unit " +
            "from cart_details c join medicine m on m.id = c.medicine_id join unit_detail u on m.id = u.medicine_id " +
            "where c.app_user_id = :id ")
    List<ICartDetailProjectionWhenSell> getAllCardByAppUserId(@Param("id") Long id);


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all prescription by name
     * @param name
     * @return list prescription
     */
    @Query(nativeQuery = true, value = "select p.id, p.code, p.name, p.symptoms, p.note, pa.name as patient_name \n" +
            "from prescription p join patient pa \n" +
            "on p.patient_id = pa.id where p.name like %:name% and p.flag_deleted = false")
    List<IPrescriptionProjectionOrder> getAllPrescriptionByName(@Param("name")String name);


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all prescription by symptoms
     * @param symptoms
     * @return list prescription
     */
    @Query(nativeQuery = true, value = "select p.id, p.code, p.name, p.symptoms, p.note, pa.name as patient_name \n" +
            "from prescription p join patient pa \n" +
            "on p.patient_id = pa.id where p.symptoms like %:symptoms% and p.flag_deleted = false")
    List<IPrescriptionProjectionOrder> getAllPrescriptionBySymptoms(@Param("symptoms")String symptoms);

    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all indication from prescription id
     * @param id
     * @return list indication
     */
    @Query(nativeQuery = true, value = "select i.id,i.dosage,i.frequency,i.medicine_id,m.name from indication i \n" +
            "join medicine m on m.id = i.medicine_id where i.prescription_id = :id")
    List<IIndicationProjectionOrder> getAllIndicationByPrescriptionId(@Param("id") Long id);


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get name and user app id of customer from phone number
     * @param phone
     * @return name and app user id
     */
    @Query(nativeQuery = true, value = "select c.name, c.app_user_id from customer c " +
            "where c.phone_number = :phone and c.flag_deleted = false")
    ICustomerProjectionWhenSell getCustomerName(@Param("phone") String phone);

    /**

     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get quantity of a product in cart;
     * @param : appUserId, medicineId;
     * @return : product's quantity;
     */
    @Query(nativeQuery = true, value = "SELECT cd.quantity FROM cart_details cd " +
            "WHERE cd.app_user_id = :appUserId AND cd.medicine_id = :medicineId")
    Long findMedicineQuantityInCart(@Param("appUserId") Long appUserId, @Param("medicineId") Long medicineId);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get loyalty point of customer;
     * @param : appUserId;
     * @return : loyalty point;
     */
    @Query(nativeQuery = true, value = "select c.point from customer c where c.app_user_id = :appUserId")
    Long getLoyaltyPoint(@Param("appUserId") Long appUserId);

}
