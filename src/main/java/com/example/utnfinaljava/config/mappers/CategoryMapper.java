package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.CategoryDto;
import com.example.utnfinaljava.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source="id", target="categoryId")
    CategoryDto categoryToCategoryDto(Category loc);

    @Mapping(source="categoryId", target="id")
    Category categoryDtoToCategory(CategoryDto dto);
    
    List<CategoryDto> categoryListToCategoryListDto(List<Category> categories);
}
