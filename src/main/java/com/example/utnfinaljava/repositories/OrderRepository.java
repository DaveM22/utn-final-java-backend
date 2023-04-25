package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
