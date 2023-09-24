package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    /**
     * author: VuNL
     * date create: 15/09/2023
     * function: create order detail when pay
     * @param currentPrice
     * @param orderId
     * @param medicineId
     * @param quantity
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into order_details(current_price, order_id, medicine_id, quantity)\n" +
            "values (:currentPrice, :orderId, :medicineId, :quantity)")
    void createOrderDetails(@Param("currentPrice")Double currentPrice,@Param("orderId") Long orderId,
                            @Param("medicineId")Long medicineId,@Param("quantity")Long quantity);
}
