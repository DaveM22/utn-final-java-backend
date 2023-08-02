package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.utnfinaljava.config.mappers.PriceMapper;
import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.entities.Price;
import com.example.utnfinaljava.entities.claves_compuestas.PriceId;
import com.example.utnfinaljava.interfaces.PriceService;
import com.example.utnfinaljava.repositories.PriceRepository;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.PriceIsZeroOrNullException;

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
    public PriceDto setPrice(PriceDto dto) {
        PriceId id = new PriceId();
        id.setPersonaId(dto.getPersonaId());
        id.setProductId(dto.getProductId());
        id.setDateFrom(dto.getDateFrom());
        if(priceRepository.existsById(id)){
            throw new AlreadyExistException("Ya existe un precio asignado para la fecha ingresada");
        }
        if(dto.getPrice().equals(null) || dto.getPrice() <= 0){
            throw new PriceIsZeroOrNullException("No se puede asignar un precio con un valor igual o menor a cero");
        }

        Price entity = priceMapper.priceDtoToPrice(dto);
        Price saved = priceRepository.save(entity);
        return priceMapper.priceToPriceDto(saved);
    }

    @Override
    public void deletePrice(Long idPersona, Long idPrice, Date date) {
        PriceId priceId = new PriceId();
        priceId.setDateFrom(date);
        priceId.setPersonaId(idPersona);
        priceId.setProductId(idPrice);
        this.priceRepository.deleteById(priceId);
    }

}
