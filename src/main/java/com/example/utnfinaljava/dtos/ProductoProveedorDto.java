package com.example.utnfinaljava.dtos;

import lombok.Data;
import lombok.Setter;


@Data
public class ProductoProveedorDto {
    private String cuit;
    private Long idProducto;
    private Long cantidad;
    private String nombreProveedor;
}
