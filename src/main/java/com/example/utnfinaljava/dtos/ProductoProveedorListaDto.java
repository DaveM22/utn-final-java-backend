package com.example.utnfinaljava.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ProductoProveedorListaDto {
    private String nombreProducto;
    private List<ProductSupplierDto> productoProveedores;
}
