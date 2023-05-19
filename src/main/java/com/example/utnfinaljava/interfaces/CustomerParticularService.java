package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.CustomerParticularDto;

public interface CustomerParticularService {
    public List<CustomerParticularDto> getAll();
    public CustomerParticularDto create(CustomerParticularDto customer);
    public CustomerParticularDto edit(CustomerParticularDto customer);
    public void delete(Long id);
}
