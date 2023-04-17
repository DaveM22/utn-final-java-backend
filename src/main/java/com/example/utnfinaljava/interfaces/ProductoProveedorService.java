package com.example.utnfinaljava.interfaces;

import java.util.List;
import com.example.utnfinaljava.dtos.ProductoProveedorListaDto;


public interface ProductoProveedorService {
    ProductoProveedorListaDto ListaProductosProveedor(Long productoId);
}
