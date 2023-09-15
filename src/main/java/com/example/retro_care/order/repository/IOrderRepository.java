package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {


}
