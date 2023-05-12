package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.Discount;
import com.example.utnfinaljava.entities.claves_compuestas.DiscountId;

public interface DiscountRepository extends JpaRepository<Discount, DiscountId> {
    
}
