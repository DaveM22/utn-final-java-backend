package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.dtos.ProductoProveedorListaDto;

public interface ProductSupplierService {

    List<ProductSupplierDto> listaProductoProveedor();

    ProductoProveedorListaDto ListaProductosProveedor(Long productoId);

    ProductSupplierDto AddProductSupplier(ProductSupplierDto supplier);
}
