package com.example.utnfinaljava.interfaces;

import java.util.Date;
import java.util.List;

import com.example.utnfinaljava.dtos.PriceDto;

public interface PriceService {
    List<PriceDto> getPriceById(Long productId,Long personaId);

    PriceDto setPrice(PriceDto dto);

    void deletePrice(Long idPersona, Long idPrice, Date date);
}
