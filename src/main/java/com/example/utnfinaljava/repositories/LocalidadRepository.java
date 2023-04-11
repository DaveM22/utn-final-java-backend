package com.example.utnfinaljava.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.utnfinaljava.entities.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
}
