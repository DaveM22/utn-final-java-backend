package com.example.utnfinaljava.dtos;

import java.util.List;
import lombok.Data;

@Data
public class ProductSupplierDto {
    private Long personaId;
    private String cuit;
    private Long productId;
    private String productName;
    private Integer amount;
    private String supplierName;
    private List<PriceDto> prices;
    private Long validityPrice;
}
