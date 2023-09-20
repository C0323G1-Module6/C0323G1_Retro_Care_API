package com.example.retro_care.report.repository;

import com.example.retro_care.order.model.OrderDetails;
import com.example.retro_care.report.dto.SaleDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISaleDiaryRepository extends JpaRepository<OrderDetails, Long> {

    /**
     * Author: DuyTV
     * Goal: Get data of sale diary report
     * Date created: 15/09/2023
     * @param startDate
     * @param endDate
     * @return List of SaleDiary
     */
    @Query(value = "SELECT e.id, e.name_employee as name, o.date_time as sellDate, SUM(od.current_price * od.quantity) AS total " +
            "FROM orders o " +
            "JOIN order_details od ON o.id = od.order_id " +
            "JOIN user_order u ON o.id = u.order_id " +
            "JOIN app_user a ON u.app_user_id = a.id " +
            "JOIN employee e ON a.id = e.app_user_id " +
            "AND o.date_time BETWEEN :startDate AND :endDate " +
            "GROUP BY e.id, e.name_employee, o.date_time" +
            " ORDER BY o.date_time ASC ", nativeQuery = true)
    List<SaleDiary> findSaleDiary(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);
}
