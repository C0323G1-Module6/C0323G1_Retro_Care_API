package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.*;
import com.example.retro_care.order.projection.*;
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


    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.quantity, ud.conversion_rate " +
            "FROM medicine AS m" +
            " JOIN unit_detail AS ud ON m.id = ud.medicine_id" +
            " WHERE m.id = :medicineId")
    MedicineQuantityProjection getQuantityBasedOnUnit(@Param("medicineId") Long medicineId);

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

}
