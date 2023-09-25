package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.Orders;
import com.example.retro_care.order.projection.IOrderProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
@Transactional
public interface IOrderRepository extends JpaRepository<Orders, Long> {

    /**
     * Author: TanNV
     * Date: 25/09/2023
     * get list invoice order
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated order list with limit number of molecules per page.
     */
    @Query(value = " SELECT\n" +
            "        o.code AS code,\n" +
            "        MAX(e.name_employee) AS nameEmployee,\n" +
            "        MAX(c.name) AS nameCustomer,\n" +
            "        o.date_time AS orderDate,\n" +
            "        sum(od.current_price) AS orderDetailsPrice,\n" +
            "        o.note as orderNote\n" +
            "    FROM\n" +
            "        orders o\n" +
            "            LEFT JOIN user_order uo ON o.id = uo.order_id\n" +
            "            LEFT JOIN app_user au ON uo.app_user_id = au.id\n" +
            "            LEFT JOIN employee e ON au.id = e.app_user_id\n" +
            "            LEFT JOIN customer c ON au.id = c.app_user_id\n" +
            "\t\t\t\tLEFT JOIN order_details od  ON od.order_id = o.id\n" +
            "            LEFT JOIN user_role ur  ON ur.app_user_id = au.id\n" +
            "            LEFT JOIN app_role ar  ON ur.app_role_id = ar.id\n" +
            "  \n" +
            "    GROUP BY o.`code`", nativeQuery = true)
    Page<IOrderProjection> getAllList1(Pageable pageable);


    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: get list for order by id;
     *
     * @return : If the id parameter is found, the data of that id will be displayed.
     * @Param Long id;
     */
    @Query(value = "SELECT o.code AS order_code, e.name_employee AS name_employee , customer.name AS name, " +
            "DATE(o.date_time) AS order_date, TIME(o.date_time) AS order_time, od.current_price AS order_details_price, " +
            "o.note AS order_note " +
            "FROM orders as o " +
            "INNER JOIN employee as e ON o.id = e.id " +
            "INNER JOIN user_order as uo ON o.id = uo.id " +
            "INNER JOIN app_user as au ON uo.id = au.id " +
            "INNER JOIN customer as customer au.id = customer.id " +
            "INNER JOIN order_details as od ON o.id = od.id where o.flag_delete=0 and o.id=:id ", nativeQuery = true)
    Orders findByOrder(@Param("id") Long id);


    /**
     * author: VuNL
     * function: create orders when pay
     * date create: 15/09/2023
     *
     * @param code
     * @param note
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into orders(code, date_time, flag_deleted, note)\n" +
            "values (:code, localtime(), false, :note)")
    void createOrder(@Param("code") String code, @Param("note") String note);


    /**
     * author: VuNL
     * date create: 15/09/2023
     * function: get the newest orders
     *
     * @return the newest orders
     */
    @Query(nativeQuery = true, value = "SELECT MAX(id) FROM orders WHERE flag_deleted = false")
    Long getLastInsertOrders();



    /**
     * author: VuNL
     * date create: 15/09/2023
     * function: edit the quantity of medicine when customer buy medicine
     *
     * @param quantity
     * @param id
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update medicine\n" +
            "set quantity = :quantity\n" +
            "where id = :id")
    void updateMedicineQuantity(@Param("quantity") Long quantity, @Param("id") Long id);


    /**
     * author: VuNL
     * date create: 15/09/2023
     * function: get the quantity of medicine
     *
     * @param id
     * @return the quantity of medicine
     */
    @Query(nativeQuery = true, value = "select quantity\n" +
            "from medicine\n" +
            "where id = :id")
    Long getMedicineQuantityById(@Param("id") Long id);


    /**
     * author: VuNL
     * date create: 15/09/2023
     * function: get the point of customer
     *
     * @param id
     * @return the point of customer
     */
    @Query(nativeQuery = true, value = "select point\n" +
            "from customer\n" +
            "where app_user_id = :id\n")
    Long getPointCustomerByAppUserId(@Param("id") Long id);


    /**
     * author: VuNL
     * date create: 15/09/2023
     * function: edit the point of customer
     *
     * @param point
     * @param id
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update customer set point = :point " +
            "where app_user_id = :id")
    void updatePointCustomer(@Param("point") Long point, @Param("id") Long id);

    /**
     * Author:TanNv
     * Date:25/09/2023
     * Get list by date time
     * @return : If the correct parameter is passed, the list will be filtered according to that parameter,
     * otherwise the original list will be returned.
     */
    @Query(value ="SELECT o.code AS code, e.name_employee AS nameEmployee , customer.name AS nameCustomer, " +
            "DATE(o.date_time) AS orderDate, TIME(o.date_time) AS orderTime, od.current_price AS orderDetailsPrice, " +
            "o.note AS orderNote " +
            "FROM orders as o " +
            "INNER JOIN employee as e ON o.id = e.id " +
            "INNER JOIN user_order as uo ON o.id = uo.id " +
            "INNER JOIN app_user as au ON uo.id = au.id " +
            "INNER JOIN customer as customer ON au.id = customer.id " +
            "INNER JOIN order_details as od ON o.id = od.id where o.flag_deleted = 0 " +
            "and o.date_time >= :startDateTime AND o.date_time <= :endDateTime", nativeQuery = true)
    Page<IOrderProjection> findByDateTimeRange(Pageable pageable,@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: create new order and update loyalty point of a customer;
     *
     * @param : appUserId, loyaltyPoint;
     */
    @Modifying
    @Procedure("createOrder")
    Long createOrderForUser(@Param("appUserId") Long appUserId, @Param("loyaltyPoint") Long loyaltyPoint,
                               @Param("cartIDsInText") String cartIDsInText);
    @Query(nativeQuery = true, value = "SELECT code FROM orders WHERE id = :orderId")
    String getOrderCodeByOrderId(@Param("orderId") Long orderId);

}
