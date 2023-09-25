package com.example.retro_care.report.repository;

import com.example.retro_care.order.model.OrderDetails;
import com.example.retro_care.report.dto.Profit;
import com.example.retro_care.report.dto.ProfitDto;
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
    @Query(value = "SELECT o.date_time AS sellDate, SUM((od.current_price -(m.price-(m.price*( m.retail_profits + m.vat + invd.discount)/100))) * od.quantity) AS total " +
            "FROM orders o JOIN order_details od ON o.id = od.order_id " +
            "JOIN medicine m ON od.medicine_id = m.id " +
            "JOIN invoice_detail invd ON m.id = invd.medicine_id "+
            "WHERE o.flag_deleted = 0 " +
            "AND o.date_time BETWEEN :startDate AND :endDate " +
            "GROUP BY o.date_time " +
            "ORDER BY o.date_time ASC ", nativeQuery = true)
    List<Profit> findProfit(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);

     @Query(value = " SELECT o.id as id,m.price , o.date_time as dateTime, od.current_price as currentPrice,od.quantity, m.retail_profits as retailProfits, m.vat, invd.discount " +
             "            FROM orders o JOIN order_details od ON o.id = od.order_id  " +
             "            left JOIN medicine m ON od.medicine_id = m.id  " +
             "             join invoice_detail invd ON m.id = invd.medicine_id " +
             "            WHERE o.flag_deleted = 0 " +
             "            AND o.date_time BETWEEN :startDate AND :endDate " +
             "             ORDER BY o.date_time ASC ",nativeQuery = true)
     List<ProfitDto> getAllProfit(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);

}
