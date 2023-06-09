package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.SupplierDto;

public interface SupplierService {
    List<SupplierDto> getSupplier();
    SupplierDto create(SupplierDto supplier);
    SupplierDto edit(SupplierDto supplier);
    void delete(Long id);
}
