package com.example.retro_care.report.repository;

import com.example.retro_care.order.model.OrderDetails;
import com.example.retro_care.report.dto.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfitRepository extends JpaRepository<OrderDetails, Long> {

    /**
     * Author: DuyTV
     * Goal: Get data of profit report
     * Date created: 15/09/2023
     *
     * @param startDate
     * @param endDate
     * @return List of Profit
     */
    @Query(value = "SELECT o.date_time AS sellDate, SUM((od.current_price -m.price) * od.quantity) AS total " +
            "FROM orders o JOIN order_details od ON o.id = od.order_id " +
            "JOIN medicine m ON od.medicine_id = m.id " +
            "WHERE o.flag_deleted = 0 " +
            "AND o.date_time BETWEEN :startDate AND :endDate " +
            "GROUP BY o.date_time " +
            "ORDER BY o.date_time ASC ", nativeQuery = true)
    List<Profit> findProfit(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);


}
