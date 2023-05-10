package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.utnfinaljava.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    
}
