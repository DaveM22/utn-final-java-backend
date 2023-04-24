package com.example.utnfinaljava.interfaces;

import java.util.List;
import com.example.utnfinaljava.dtos.ProductoProveedorListaDto;


public interface ProductSupplierService {
    ProductoProveedorListaDto ListaProductosProveedor(Long productoId);
}
