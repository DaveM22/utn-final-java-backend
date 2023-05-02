package com.example.utnfinaljava.interfaces;

import java.util.List;
import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.dtos.CustomerParticularDto;

public interface PersonaService {
    
    public List<CustomerParticularDto> getCustomerParticular();

    public List<CustomerCompanyDto> getCustomerCompany();

    public void RemoveCustomerParticular(Long id);

    public void RemoveCustomerCompany(Long id);

    public CustomerCompanyDto save(CustomerCompanyDto customer);

    public CustomerParticularDto save(CustomerParticularDto customer);
}
