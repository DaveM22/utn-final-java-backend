package com.example.utnfinaljava.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.utnfinaljava.entities.Price;
import com.example.utnfinaljava.entities.claves_compuestas.PriceId;

public interface PriceRepository extends JpaRepository<Price, PriceId> {
    List<Price> findByIdPersonaIdAndIdProductId(Long personaId, Long productId);

    List<Price> findByIdProductId(Long productId);
}
