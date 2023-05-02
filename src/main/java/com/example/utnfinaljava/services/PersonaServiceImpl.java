package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.PersonaDto;
import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.entities.Customer;
import com.example.utnfinaljava.entities.CustomerCompany;
import com.example.utnfinaljava.entities.CustomerParticular;
import com.example.utnfinaljava.entities.Persona;
import com.example.utnfinaljava.interfaces.PersonaService;
import com.example.utnfinaljava.repositories.CustomerCompanyRepository;
import com.example.utnfinaljava.repositories.CustomerParticularRepository;
import com.example.utnfinaljava.repositories.CustomerRepository;
import com.example.utnfinaljava.repositories.PersonaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService {

    private final CustomerRepository customerRepository;

    private final PersonaRepository personaRepository;

    private final CustomerParticularRepository customerParticularRepository;

    private final CustomerCompanyRepository customerCompanyRepository;

	@Override
	public List<CustomerParticularDto> getCustomerParticular() {
		var entities = customerRepository.findByidTipoclienteEquals(1L);
        List<CustomerParticularDto> particularDtos = new ArrayList<CustomerParticularDto>();
        for (Customer customer : entities) {
            CustomerParticularDto dto = new CustomerParticularDto();
            dto.setFirstName(customer.getParticular().getFirstName());
            dto.setLastName(customer.getParticular().getLastName());
            dto.setDni(customer.getParticular().getDni());
            dto.setDirection(customer.getPersona().getDireccion());
            dto.setPhoneNumber(customer.getPersona().getTelefono());
            dto.setId(customer.getId());
            dto.setPostalCod(customer.getPersona().getPostalCode());
            dto.setEmail(customer.getPersona().getEmail());
            particularDtos.add(dto);
        }
        return particularDtos;
    }

    @Override
    public List<CustomerCompanyDto> getCustomerCompany() {
        var entities = customerRepository.findByidTipoclienteEquals(2L);
        List<CustomerCompanyDto> companies = new ArrayList<CustomerCompanyDto>();
        for (Customer customer : entities) {
            CustomerCompanyDto dto = new CustomerCompanyDto();
            dto.setBusinessName(customer.getCompany().getBusinessName());
            dto.setCuit(customer.getCompany().getCuit());
            dto.setDirection(customer.getPersona().getDireccion());
            dto.setPhoneNumber(customer.getPersona().getTelefono());
            dto.setId(customer.getId());
            dto.setEmail(customer.getPersona().getEmail());
            dto.setPostalCod(customer.getPersona().getPostalCode());
            companies.add(dto);
        }
        return companies;
    }



	@Override
    @Transactional
	public CustomerParticularDto save(CustomerParticularDto customer) {
		Persona per = new Persona();
        per.setId(customer.getId());
        per.setDireccion(customer.getDirection());
        per.setEmail(customer.getEmail());
        per.setTelefono(customer.getPhoneNumber());
        per.setPostalCode(2000L);
        Persona saved = personaRepository.save(per);
        Customer customerEntity = new Customer();
        customerEntity.setId(saved.getId());
        customerEntity.setIdTipocliente(1L);
        customerRepository.save(customerEntity);
        CustomerParticular particular = new CustomerParticular();
        particular.setFirstName(customer.getFirstName());
        particular.setLastName(customer.getLastName());
        particular.setDni(customer.getDni());
        particular.setId(saved.getId());
        customerParticularRepository.save(particular);
        customer.setId(saved.getId());
        return customer;
	}

    @Override
    @Transactional
    public void RemoveCustomerParticular(Long id) {
        this.customerRepository.deleteById(id);
        this.customerParticularRepository.deleteById(id);
        this.personaRepository.deleteById(id);
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
        per.setDireccion(customer.getDirection());
        per.setEmail(customer.getEmail());
        per.setTelefono(customer.getPhoneNumber());
        per.setPostalCode(2000L);
        Persona saved = personaRepository.save(per);
        Customer customerEntity = new Customer();
        customerEntity.setId(saved.getId());
        customerEntity.setIdTipocliente(1L);
        customerRepository.save(customerEntity);
        CustomerCompany company = new CustomerCompany();
        company.setBusinessName(customer.getBusinessName());
        company.setCuit(customer.getCuit());
        customerCompanyRepository.save(company);
        customer.setId(saved.getId());
        return customer;
    }
  
}
