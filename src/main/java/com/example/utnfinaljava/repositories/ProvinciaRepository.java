package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.utnfinaljava.entities.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia,Long> {
    
}
