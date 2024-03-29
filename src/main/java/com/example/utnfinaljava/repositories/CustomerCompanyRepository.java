package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.CustomerCompany;

public interface CustomerCompanyRepository extends JpaRepository<CustomerCompany, Long> {
    boolean existsByCuit(String cuit);
}
