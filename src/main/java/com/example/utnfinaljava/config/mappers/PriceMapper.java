package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.entities.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(source = "id.personaId", target = "personaId")
    @Mapping(source = "id.dateFrom", target = "dateFrom")
    @Mapping(source = "id.productId", target = "productId")
    PriceDto priceToPriceDto(Price price);

    @Mapping(source = "personaId", target = "id.personaId")
    @Mapping(source = "dateFrom", target = "id.dateFrom")
    @Mapping(source = "productId", target = "id.productId")
    Price priceDtoToPrice(PriceDto dto);

    List<PriceDto> priceListToPriceListDto(List<Price> prices);
}
