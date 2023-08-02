package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.entities.Customer;
import com.example.utnfinaljava.entities.CustomerCompany;
import com.example.utnfinaljava.entities.Persona;

@Mapper(componentModel = "spring")
public interface CustomerCompanyMapper {
    CustomerCompanyMapper INSTANCE = Mappers.getMapper(CustomerCompanyMapper.class);

    @Mapping(source = "customer.persona.phoneNumber", target = "phoneNumber")
    @Mapping(source = "customer.persona.email", target = "email")
    @Mapping(source = "customer.persona.direction", target = "direction")
    @Mapping(source = "customer.persona.location.postalCode", target = "postalCode")
    CustomerCompanyDto customerCompanyToCustomerComapanyDto(CustomerCompany company);

    
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email" , target = "email")
    @Mapping(source = "direction", target = "direction")
    @Mapping(source = "postalCode", target = "postalCode")
    Persona customerParticularDtoToPersona(CustomerCompanyDto particularDto);

    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "id", ignore = true)
    Customer customerCompanyDtoToCustomer(CustomerCompanyDto comapanyDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    CustomerCompany customerCompanyDtoToCustomerCompany(CustomerCompanyDto particularDto);


    List<CustomerCompanyDto> customerParticularListToCustomerParticularDtoListDto(List<CustomerCompany> customers);
}
