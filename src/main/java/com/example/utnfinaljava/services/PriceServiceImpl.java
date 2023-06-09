package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.config.mappers.PriceMapper;
import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.entities.Price;
import com.example.utnfinaljava.entities.claves_compuestas.PriceId;
import com.example.utnfinaljava.interfaces.PriceService;
import com.example.utnfinaljava.repositories.PriceRepository;

import lombok.AllArgsConstructor;

@Service

@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    @Override
    public List<PriceDto> getPriceById(Long productId, Long personaId) {
        PriceId id = new PriceId();
        id.setPersonaId(productId);
        id.setProductId(personaId);
        List<Price> precios = priceRepository.findAll();
        List<PriceDto> dtos = new ArrayList<PriceDto>();

        for (Price price : precios) {
            if (price.getId().personaId == personaId && price.getId().productId == productId) {
                PriceDto dto = new PriceDto();
                dto.setPersonaId(price.getId().getPersonaId());
                dto.setProductId(price.getId().getProductId());
                dto.setDateFrom(price.getId().getDateFrom());
                dto.setPrice(price.getPrice());
                dtos.add(dto);
            }
        }
        return dtos;
    }

    @Override
    public PriceDto SetPrice(PriceDto dto) {
        Price entity = priceMapper.priceDtoToPrice(dto);
        Price saved = priceRepository.save(entity);
        return priceMapper.priceToPriceDto(saved);
    }

}
