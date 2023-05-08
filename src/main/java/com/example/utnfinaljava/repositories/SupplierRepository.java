package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    
}
