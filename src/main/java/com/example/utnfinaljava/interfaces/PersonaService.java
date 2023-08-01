package com.example.utnfinaljava.interfaces;

import java.util.List;
import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.dtos.SupplierDto;

public interface PersonaService {
    
    public List<CustomerCompanyDto> getCustomerCompany();

    public List<SupplierDto> getSupplier();

    public void delete(Long id);

    public void RemoveSupplier(Long id);

    public CustomerCompanyDto save(CustomerCompanyDto customer);

    public SupplierDto save(SupplierDto suplier);
}
