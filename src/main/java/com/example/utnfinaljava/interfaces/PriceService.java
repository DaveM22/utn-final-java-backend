package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.PriceDto;

public interface PriceService {
    List<PriceDto> getPriceById(Long personaId, Long productId);

    PriceDto SetPrice(PriceDto dto);
}
