package com.example.retro_care.report.repository;

import com.example.retro_care.order.model.OrderDetails;
import com.example.retro_care.report.dto.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRevenueRepository extends JpaRepository<OrderDetails, Long> {
    @Query(value = "SELECT o.date_time AS sellDate, SUM(od.current_price * od.quantity) AS total" +
            "FROM `orders` o JOIN `order_details` od ON o.id = od.order_id" +
            "WHERE o.flag_deleted = 1" +
            "AND o.date_time BETWEEN :startDate AND :endDate" +
            "GROUP BY o.date_time", nativeQuery = true)
    List<Revenue> findRevenue(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);
}