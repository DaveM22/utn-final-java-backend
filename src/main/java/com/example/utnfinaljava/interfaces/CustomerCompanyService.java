package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.CustomerCompanyDto;

public interface CustomerCompanyService {
    List<CustomerCompanyDto> getAll();
    public CustomerCompanyDto create(CustomerCompanyDto customer);
    public CustomerCompanyDto edit(CustomerCompanyDto customer);
    public void delete(Long id);
}
