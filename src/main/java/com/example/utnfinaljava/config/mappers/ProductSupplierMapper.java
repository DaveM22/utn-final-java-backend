package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.entities.ProductSupplier;

@Mapper(componentModel = "spring",  uses = PriceMapper.class)
public interface ProductSupplierMapper {
    ProductSupplierMapper INSTANCE = Mappers.getMapper(ProductSupplierMapper.class);

    @Mapping(source = "id.personaId", target = "personaId")
    @Mapping(source = "id.productId", target = "productId")
    @Mapping(source = "prices", target =  "prices")
    @Mapping(source = "supplier.cuit", target = "cuit")
    @Mapping(source = "supplier.businessName", target = "supplierName")
    @Mapping(source = "product.description", target = "productName")
    @Mapping(target = "validityPrice", expression = "java(productSupplier.getValidityPrice())")
    ProductSupplierDto productSupplierToProductSupplierDto(ProductSupplier productSupplier);

    @Mapping(source="personaId", target="id.personaId")
    @Mapping(source = "productId", target = "id.productId")
    @Mapping(target = "prices", ignore = true)
    @Mapping(target = "supplier", ignore = true)
    @Mapping(target =  "product", ignore = true)
    ProductSupplier productSupplierDtoToProductSupplier(ProductSupplierDto dto);

   List<ProductSupplierDto> productSupplierListToProductSupplierListDto(List<ProductSupplier> productSuppliers);
}
