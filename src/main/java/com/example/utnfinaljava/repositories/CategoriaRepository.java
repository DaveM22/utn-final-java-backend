package com.example.utnfinaljava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.utnfinaljava.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
