package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.utnfinaljava.entities.Province;

public interface ProvinceRepository extends JpaRepository<Province,Long> {
    
}
