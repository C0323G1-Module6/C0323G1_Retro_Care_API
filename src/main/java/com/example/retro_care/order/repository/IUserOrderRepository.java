package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IUserOrderRepository extends JpaRepository<UserOrder, Long> {
    /**
     * author: VuNL
     * date: 15/09/2023
     * function: create user order when pay
     * @param appUserId
     * @param orderId
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into user_order(app_user_id, order_id) values (:app_user_id, :order_id)")
    void createUserOrder(@Param("app_user_id") Long appUserId, @Param("order_id") Long orderId);

}
