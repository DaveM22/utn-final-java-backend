package com.example.utnfinaljava.dtos;

import lombok.Data;

@Data
public class ProductoDto {
    private Long id;
    private String descripcion;
    private Long idCategoria;
    private String categoria;
    private Long cantidad;
}
