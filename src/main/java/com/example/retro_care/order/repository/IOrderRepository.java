package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.IOrderProjection;
import com.example.retro_care.order.model.Orders;
import com.sun.tools.javac.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.time.LocalDateTime;


public interface IOrderRepository extends JpaRepository<Orders,Long> {

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: displays a paginated list of order;
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated order list with limit number of molecules per page.
     */
    @Query(value = "SELECT  o.code , e.name_employee AS name_employee , c.name AS name_customer, " +
            "DATE(o.date_time) AS order_date, TIME(o.date_time) AS order_time, od.current_price AS order_details_price, " +
            "o.note AS order_note " +
            "FROM orders o " +
            "INNER JOIN employee e ON o.id = e.id " +
            "INNER JOIN user_order uo ON o.id = uo.id " +
            "INNER JOIN app_user au ON uo.id = au.id " +
            "INNER JOIN customer c ON au.id = c.id " +
            "INNER JOIN order_details od ON o.id = od.id ", nativeQuery = true)
//    @Query(nativeQuery = true, value = "select * from orders")
    Page<IOrderProjection> getAllList1(Pageable pageable);


//
    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: get list for order by id;
     * @Param Long id;
     * @return : If the id parameter is found, the data of that id will be displayed.
     */
    @Query(value = "SELECT o.code AS order_code, e.name_employee AS name_employee , customer.name AS name, " +
            "DATE(o.date_time) AS order_date, TIME(o.date_time) AS order_time, od.current_price AS order_details_price, " +
            "o.note AS order_note " +
            "FROM orders as o " +
            "INNER JOIN employee as e ON o.id = e.id " +
            "INNER JOIN user_order as uo ON o.id = uo.id " +
            "INNER JOIN app_user as au ON uo.id = au.id " +
            "INNER JOIN customer as customer au.id = customer.id " +
            "INNER JOIN order_details as od ON o.id = od.id where o.flag_delete=0 and o.id=:id ",nativeQuery = true)
    Orders findByOrder(@Param("id")Long id);

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Delete for order by id;
     * @Param Long id;
     * @return :If the passed id parameter is found, the word with that id will be removed from the list
     */
    @Transactional
    @Modifying
    @Query(value = "update orders set flag_delete = true where id = :id", nativeQuery = true)
    void deleteOrder(@Param("id") Long id);

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Filter for order by datetime;
     * @return : If the correct parameter is passed, the list will be filtered according to that parameter,
     * otherwise the original list will be returned.
     */
    @Query(value = "SELECT * FROM orders WHERE datetime >= :startDateTime AND datetime <= :endDateTime", nativeQuery = true)
    List<Orders> findByDateTimeRange(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);
}
