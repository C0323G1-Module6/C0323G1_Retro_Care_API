package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders, Long> {


}
