package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface IOrderRepository extends JpaRepository<Orders, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "call createOrder(:appUserId)")
    void createOrderForUser(@Param("appUserId") Long appUserId);





}
