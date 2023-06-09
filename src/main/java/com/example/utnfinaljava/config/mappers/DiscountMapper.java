package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.DiscountDto;
import com.example.utnfinaljava.entities.Discount;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    @Mapping(source = "id.amountPrice", target="amountPrice")
    @Mapping(source =  "id.validityDate", target = "validityDate")
    DiscountDto discountToDiscountDto(Discount discount);

    @Mapping(source = "amountPrice", target = "id.amountPrice")
    @Mapping(source = "validityDate", target = "id.validityDate")
    Discount discountDtoToDiscount(DiscountDto discount);

    List<DiscountDto> discountListToDiscountListDto(List<Discount> discounts);
}
