package com.example.utnfinaljava.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ProductSupplierListDto {
    private String productName;
    private List<ProductSupplierDto> productSuppliers;
}
