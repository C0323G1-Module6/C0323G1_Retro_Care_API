package com.example.retro_care.order.repository;

import com.example.retro_care.order.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartDetailsRepository extends JpaRepository<CartDetails, Long> {

    
}
