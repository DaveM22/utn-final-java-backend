package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source="total", target="amount")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "category.id", target="categoryId")
    ProductDto ProductToProductDto(Product pro);

    @Mapping(source = "categoryName", target = "category.name")
    @Mapping(source = "categoryId", target="category.id")
    @Mapping(target = "suppliers", ignore = true)
    Product ProductDtoToProduct(ProductDto pro);

    List<ProductDto> ProductListToProductDtoList(List<Product> prods);
}
