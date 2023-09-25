package com.example.retro_care.order.service;

import com.example.retro_care.order.projection.IOrderProjection;
import com.example.retro_care.order.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {

    /**
     * Author:TanNV
     * Date: 25/09/2023
     * Get list invoice
     * @param pageable
     * @return
     */
    Page<IOrderProjection> getListOrder(Pageable pageable);

    /**
     * Author:TanNV
     * Date: 25/09/2023
     * Get list by date time
     * @return : If the correct parameter is passed, the list will be filtered according to that parameter,
     * otherwise the original list will be returned.
     */
    Page<IOrderProjection> findByDateTimeRange(Pageable pageable,LocalDateTime startDateTime, LocalDateTime endDateTime);

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


