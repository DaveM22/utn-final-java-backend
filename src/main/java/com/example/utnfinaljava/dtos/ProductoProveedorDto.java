package com.example.utnfinaljava.dtos;

import java.util.List;
import lombok.Data;

@Data
public class ProductoProveedorDto {
    private String cuit;
    private Long idProducto;
    private String productName;
    private Long cantidad;
    private String nombreProveedor;
    private List<PriceDto> prices;
    private Long validityPrice;
}
