package com.example.retro_care.order.service;

import com.example.retro_care.order.projection.IMedicineWhenSell;
import com.example.retro_care.order.projection.IOrderProjection;
import com.example.retro_care.order.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: displays a paginated list of order;
     *
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated order list with limit number of molecules per page.
     */
    Page<IOrderProjection> getListOrder(Pageable pageable);

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: get list for order by id;
     *
     * @return : If the id parameter is found, the data of that id will be displayed.
     * @Param Long id;
     */
    Orders findOrderById(Long id);

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Delete for order by id;
     *
     * @return :If the passed id parameter is found, the word with that id will be removed from the list
     * @Param Long id;
     */
    void deleteOrderById(Long id);

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Filter for order by datetime;
     *
     * @return : If the correct parameter is passed, the list will be filtered according to that parameter,
     * otherwise the original list will be returned.
     */
    List<Orders> findByDateTimeRange(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * author: VuNL
     * date: 15/09/2023
     * function: create orders, order detail, user order when pay offline
     *
     * @param code
     * @param customerUserId
     * @param employeeUserId
     */
    void createOfflineOrders(String code, String note, Long customerUserId, Long employeeUserId);

    /**
     * author: VuNL
     * date: 15/09/2023
     * function: create only order when pay
     *
     * @param code
     * @param node
     */
    void createOrders(String code, String node);



    /**
     * author: VuNL
     * date: 15/09/2023
     * @param customerUserId
     * @param employeeUserId
     * @param code
     * @param note
     * @return return true if success, false if fail
     */

    String doEverythingWhenPay(Long customerUserId, Long employeeUserId,String code, String note);


    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: create new order and update loyalty point of a customer;
     * @param : appUserId, loyaltyPoint;
     */
    void createOrderForUser(Long appUserId, Long loyaltyPoint);


}


