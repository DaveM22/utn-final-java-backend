package com.example.utnfinaljava.dtos;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String description;
    private Long categoryId;
    private String categoryName;
    private Long amount;
}
