package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.CustomerCompanyMapper;
import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.entities.Customer;
import com.example.utnfinaljava.entities.CustomerCompany;
import com.example.utnfinaljava.entities.Persona;
import com.example.utnfinaljava.interfaces.CustomerCompanyService;
import com.example.utnfinaljava.repositories.CustomerCompanyRepository;
import com.example.utnfinaljava.repositories.CustomerRepository;
import com.example.utnfinaljava.repositories.LocationRepository;
import com.example.utnfinaljava.repositories.PersonaRepository;
import com.example.utnfinaljava.util.exceptions.LocationNotExistException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerCompanyServiceImpl implements CustomerCompanyService {

    private final CustomerCompanyMapper customerCompanyMapper;

    private final CustomerRepository customerRepository;

    private final PersonaRepository personaRepository;

    private final CustomerCompanyRepository customerCompanyRepository;

    private final LocationRepository locationRepository;


    @Override
    public List<CustomerCompanyDto> getAll() {
        List<CustomerCompany> entities = customerCompanyRepository.findAll();
        List<CustomerCompanyDto> particularDtos = customerCompanyMapper.customerParticularListToCustomerParticularDtoListDto(entities);
        return particularDtos;
    }


    @Override
    public CustomerCompanyDto create(CustomerCompanyDto customer) throws LocationNotExistException {

        if(!locationRepository.existsById(customer.getPostalCode())){
            throw new LocationNotExistException("El código postal ingresado no esta registrado en el sistema");
        }

        Persona cus = customerCompanyMapper.customerParticularDtoToPersona(customer);
        Customer cust = customerCompanyMapper.customerCompanyDtoToCustomer(customer);
        CustomerCompany particular = customerCompanyMapper.customerCompanyDtoToCustomerCompany(customer);
        Persona personaSaved = personaRepository.save(cus);
        cust.setPersona(personaSaved);
        Customer custSaved = customerRepository.save(cust);
        particular.setCustomer(custSaved);
        customerCompanyRepository.save(particular);
        customer.setPostalCode(customer.getPostalCode());
        customer.setId(personaSaved.getId());
        return customer;
    }


    @Override
    public CustomerCompanyDto edit(CustomerCompanyDto customer) throws LocationNotExistException {

        if(!locationRepository.existsById(customer.getPostalCode())){
            throw new LocationNotExistException("El código postal ingresado no esta registrado en el sistema");
        }
        Persona cus = customerCompanyMapper.customerParticularDtoToPersona(customer);
        Customer cust = customerCompanyMapper.customerCompanyDtoToCustomer(customer);
        CustomerCompany particular = customerCompanyMapper.customerCompanyDtoToCustomerCompany(customer);
        Persona personaSaved = personaRepository.save(cus);
        cust.setPersona(personaSaved);
        Customer custSaved = customerRepository.save(cust);
        particular.setCustomer(custSaved);
        customerCompanyRepository.save(particular);
        customer.setPostalCode(customer.getPostalCode());
        customer.setId(personaSaved.getId());
        return customer;
    }


    @Override
    public void delete(Long id) {
        this.customerCompanyRepository.deleteById(id);
        this.customerRepository.deleteById(id);
        this.personaRepository.deleteById(id);
    }
    
}
