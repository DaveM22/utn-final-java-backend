package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.entities.Customer;
import com.example.utnfinaljava.entities.CustomerParticular;
import com.example.utnfinaljava.entities.Persona;

@Mapper(componentModel = "spring")
public interface CustomerParticularMapper {
    
    CustomerParticularMapper INSTANCE = Mappers.getMapper(CustomerParticularMapper.class);
    @Mapping(source = "customer.persona.phoneNumber", target = "phoneNumber")
    @Mapping(source = "customer.persona.email", target = "email")
    @Mapping(source = "customer.persona.direction", target = "direction")
    @Mapping(source = "customer.persona.location.postalCode", target = "postalCode")
    CustomerParticularDto customerParticularToCustomerParticularDto(CustomerParticular particular);


    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email" , target = "email")
    @Mapping(source = "direction", target = "direction")
    @Mapping(source = "postalCode", target = "postalCode")
    Persona customerParticularDtoToPersona(CustomerParticularDto particularDto);

    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "id", ignore = true)
    Customer customerParticularDtoToCustomer(CustomerParticularDto particularDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    CustomerParticular customerParticularDtoToCustomerParticular(CustomerParticularDto particularDto);


    List<CustomerParticularDto> customerParticularListToCustomerParticularDtoListDto(List<CustomerParticular> customers);
}
