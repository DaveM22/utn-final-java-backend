package com.example.utnfinaljava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public List<Customer> findByidTipoclienteEquals(Long id);
    public List<Customer> findByCompanyIsNull();
}
