package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.entities.Price;
import com.example.utnfinaljava.entities.claves_compuestas.PreciosId;
import com.example.utnfinaljava.interfaces.PriceService;
import com.example.utnfinaljava.repositories.PriceRepository;

import lombok.AllArgsConstructor;

@Service

@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;



    @Override
    public List<PriceDto> getPriceById(Long personaId, Long productId) {
        PreciosId id = new PreciosId();
        id.setIdPersona(personaId);
        id.setProductoId(productId);
        List<Price> precios = priceRepository.findAllById(id);
        List<PriceDto> dtos = new ArrayList<PriceDto>();
        
        for (Price price : precios) {
            PriceDto dto = new PriceDto();
            dto.setPersonaId(price.getId().getIdPersona());
            dto.setProductId(price.getId().getProductoId());
            dto.setDateFrom(price.getId().getDateFrom());
            dto.setPrice(price.getPrice());
            dtos.add(dto);
        }
        return dtos;
    }



    @Override
    public PriceDto SetPrice(PriceDto dto) {
       PreciosId id = new PreciosId();
       id.setDateFrom(dto.getDateFrom());
       id.setIdPersona(dto.getPersonaId());
       id.setProductoId(dto.getProductId());
       Price price = new Price();
       price.setId(id);
       price.setPrice(dto.getPrice());
       priceRepository.save(price);
       return dto;
    }
    
}
