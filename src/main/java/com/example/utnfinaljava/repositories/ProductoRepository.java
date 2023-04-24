package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.Product;

public interface ProductoRepository extends JpaRepository<Product,Long> {
    
}
