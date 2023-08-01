package com.example.utnfinaljava.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.utnfinaljava.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
