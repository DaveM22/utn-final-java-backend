package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.ProductoProveedorDto;
import com.example.utnfinaljava.dtos.ProductoProveedorListaDto;

public interface ProductSupplierService {

    List<ProductoProveedorDto> listaProductoProveedor();

    ProductoProveedorListaDto ListaProductosProveedor(Long productoId);
}
