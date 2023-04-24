package com.example.utnfinaljava.dtos;

import java.util.List;

import lombok.Data;
import lombok.Setter;


@Data
public class ProductoProveedorDto {
    private String cuit;
    private Long idProducto;
    private Long cantidad;
    private String nombreProveedor;
    private Long ultimoPrecio;
    private List<PriceDto> prices;
    private Long validityPrice;
}
