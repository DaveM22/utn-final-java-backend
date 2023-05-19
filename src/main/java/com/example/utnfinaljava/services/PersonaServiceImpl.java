package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.PersonaDto;
import com.example.utnfinaljava.dtos.SupplierDto;
import com.example.utnfinaljava.config.mappers.CustomerParticularMapper;
import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.entities.Customer;
import com.example.utnfinaljava.entities.CustomerCompany;
import com.example.utnfinaljava.entities.CustomerParticular;
import com.example.utnfinaljava.entities.Persona;
import com.example.utnfinaljava.entities.Supplier;
import com.example.utnfinaljava.interfaces.PersonaService;
import com.example.utnfinaljava.repositories.CustomerCompanyRepository;
import com.example.utnfinaljava.repositories.CustomerParticularRepository;
import com.example.utnfinaljava.repositories.CustomerRepository;
import com.example.utnfinaljava.repositories.PersonaRepository;
import com.example.utnfinaljava.repositories.SupplierRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService {

    private final CustomerRepository customerRepository;

    private final PersonaRepository personaRepository;

    private final CustomerCompanyRepository customerCompanyRepository;

    private final SupplierRepository supplierRepository;


    @Override
    public List<CustomerCompanyDto> getCustomerCompany() {
        List<Customer> entities = customerRepository.findAll();
        List<CustomerCompanyDto> companies = new ArrayList<CustomerCompanyDto>();
        for (Customer customer : entities) {
            CustomerCompanyDto dto = new CustomerCompanyDto();
            dto.setDirection(customer.getPersona().getDirection());
            dto.setPhoneNumber(customer.getPersona().getPhoneNumber());
            dto.setId(customer.getId());
            dto.setEmail(customer.getPersona().getEmail());
            dto.setPostalCode(customer.getPersona().getLocation().getPostalCode());
            companies.add(dto);
        }
        return companies;
    }


    @Override
    @Transactional
    public void RemoveCustomerCompany(Long id) {
        this.customerRepository.deleteById(id);
        this.customerCompanyRepository.deleteById(id);
        this.personaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CustomerCompanyDto save(CustomerCompanyDto customer) {
        Persona per = new Persona();
        per.setId(customer.getId());
        per.setDirection(customer.getDirection());
        per.setEmail(customer.getEmail());
        per.setPhoneNumber(customer.getPhoneNumber());
        per.getLocation().setPostalCode(2000L);
        Persona saved = personaRepository.save(per);
        Customer customerEntity = new Customer();
        customerEntity.setId(saved.getId());
        customerRepository.save(customerEntity);
        CustomerCompany company = new CustomerCompany();
        company.setId(saved.getId());
        company.setBusinessName(customer.getBusinessName());
        company.setCuit(customer.getCuit());
        customerCompanyRepository.save(company);
        customer.setId(saved.getId());
        return customer;
    }

    @Override
    public List<SupplierDto> getSupplier() {
        List<Supplier> entities = supplierRepository.findAll();
        List<SupplierDto> supplierDtos = new ArrayList<SupplierDto>();
        for (Supplier supplier : entities) {
            SupplierDto dto = new SupplierDto();
            dto.setBusinessName(supplier.getBusinessName());
            dto.setCuit(supplier.getCuit());
            dto.setDirection(supplier.getPersona().getDirection());
            dto.setPhoneNumber(supplier.getPersona().getPhoneNumber());
            dto.setId(supplier.getId());
            dto.setEmail(supplier.getPersona().getEmail());
            dto.setPostalCode(supplier.getPersona().getLocation().getPostalCode());
            supplierDtos.add(dto);
        }
        return supplierDtos;
    }

    @Override
    @Transactional
    public void RemoveSupplier(Long id) {
        this.supplierRepository.deleteById(id);
        this.personaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public SupplierDto save(SupplierDto supplier) {
        Persona per = new Persona();
        per.setId(supplier.getId());
        per.setDirection(supplier.getDirection());
        per.setEmail(supplier.getEmail());
        per.setPhoneNumber(supplier.getPhoneNumber());
        per.getLocation().setPostalCode(2050L);
        Persona saved = personaRepository.save(per);
        Supplier newSupplier = new Supplier();
        newSupplier.setBusinessName(supplier.getBusinessName());
        newSupplier.setCuit(supplier.getCuit());
        newSupplier.setId(saved.getId());
        supplierRepository.save(newSupplier);
        supplier.setId(saved.getId());
        return supplier;
    }
  
}
