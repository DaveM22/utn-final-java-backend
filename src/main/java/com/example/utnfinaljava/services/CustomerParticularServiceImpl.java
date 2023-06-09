package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.CustomerParticularMapper;
import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.entities.Customer;
import com.example.utnfinaljava.entities.CustomerParticular;
import com.example.utnfinaljava.entities.Persona;
import com.example.utnfinaljava.interfaces.CustomerParticularService;
import com.example.utnfinaljava.repositories.CustomerCompanyRepository;
import com.example.utnfinaljava.repositories.CustomerParticularRepository;
import com.example.utnfinaljava.repositories.CustomerRepository;
import com.example.utnfinaljava.repositories.PersonaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerParticularServiceImpl implements CustomerParticularService {


    private final CustomerParticularMapper customerParticularMapper;

    private final CustomerRepository customerRepository;

    private final PersonaRepository personaRepository;

    private final CustomerParticularRepository customerParticularRepository;


    @Override
    public List<CustomerParticularDto> getAll() {
		List<CustomerParticular> entities = customerParticularRepository.findAll();
        List<CustomerParticularDto> particularDtos = customerParticularMapper.customerParticularListToCustomerParticularDtoListDto(entities);
        return particularDtos;
    }

    @Override
    @Transactional
    public CustomerParticularDto create(CustomerParticularDto customer) {
        Persona cus = customerParticularMapper.customerParticularDtoToPersona(customer);
        Customer cust = customerParticularMapper.customerParticularDtoToCustomer(customer);
        CustomerParticular particular = customerParticularMapper.customerParticularDtoToCustomerParticular(customer);
        Persona personaSaved = personaRepository.save(cus);
        cust.setPersona(personaSaved);
        Customer custSaved = customerRepository.save(cust);
        particular.setCustomer(custSaved);
        customerParticularRepository.save(particular);
        customer.setId(personaSaved.getId());
        return customer;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.customerParticularRepository.deleteById(id);
        this.customerRepository.deleteById(id);
        this.personaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CustomerParticularDto edit(CustomerParticularDto customer) {
        Persona cus = customerParticularMapper.customerParticularDtoToPersona(customer);
        Customer cust = customerParticularMapper.customerParticularDtoToCustomer(customer);
        CustomerParticular particular = customerParticularMapper.customerParticularDtoToCustomerParticular(customer);
        Persona personaSaved = personaRepository.save(cus);
        cust.setPersona(personaSaved);
        Customer custSaved = customerRepository.save(cust);
        particular.setCustomer(custSaved);
        customerParticularRepository.save(particular);
        customer.setId(personaSaved.getId());
        return customer;
    }
    
}
