package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.SupplierDto;
import com.example.utnfinaljava.entities.Persona;
import com.example.utnfinaljava.entities.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    @Mapping(source = "persona.phoneNumber", target = "phoneNumber")
    @Mapping(source = "persona.email", target = "email")
    @Mapping(source = "persona.direction", target = "direction")
    @Mapping(source = "persona.location.postalCode", target = "postalCode")
    SupplierDto supplierToSupplierDto(Supplier supplier);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email" , target = "email")
    @Mapping(source = "direction", target = "direction")
    @Mapping(source = "postalCode", target = "location.postalCode")
    Persona supplierDtoToPersona(SupplierDto particularDto);
    
    @Mapping(target = "persona", ignore = true)
    Supplier supplierDtoToSupplier(SupplierDto supplierDto);

    List<SupplierDto> supplierListToSupplierDtoListDto(List<Supplier> suppliers);
}
