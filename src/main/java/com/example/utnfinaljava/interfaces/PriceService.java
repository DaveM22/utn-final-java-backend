package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.PriceDto;

public interface PriceService {
    List<PriceDto> getPriceById(Long productId,Long personaId);

    PriceDto SetPrice(PriceDto dto);
}
