package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    /**
     * author: VuNL
     * date create: 15/09/2023
     * function: create order detail when pay
     * @param orderDetails
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into order_details(current_price, order_id, medicine_id, quantity)\n" +
            "values (:#{#orderDetails.currentPrice}, :#{#orderDetails.order.id}, :#{#orderDetails.medicine.id}, :#{#orderDetails.quantity})")
    void createOrderDetails(OrderDetails orderDetails);
}
