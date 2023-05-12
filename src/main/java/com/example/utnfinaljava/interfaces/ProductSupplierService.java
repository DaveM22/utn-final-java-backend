package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.dtos.ProductSupplierListDto;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;

public interface ProductSupplierService {

    List<ProductSupplierDto> getProductSupplier();

    ProductSupplierListDto getProductSupplerByProductId(Long productoId);

    ProductSupplierDto create(ProductSupplierDto supplier) throws AlreadyExistException;
}
