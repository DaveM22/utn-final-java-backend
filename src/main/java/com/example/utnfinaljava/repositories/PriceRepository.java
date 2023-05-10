package com.example.utnfinaljava.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.utnfinaljava.entities.Price;
import com.example.utnfinaljava.entities.claves_compuestas.PreciosId;

public interface PriceRepository extends JpaRepository<Price, PreciosId> {
    List<Price> findAllById(PreciosId id);
}
