package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.CustomerParticular;

public interface CustomerParticularRepository extends JpaRepository<CustomerParticular, Long> {
    boolean existsByDni(String dni);
}
