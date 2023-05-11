package com.example.utnfinaljava.config;

import java.util.Locale.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.utnfinaljava.dtos.CategoryDto;
import com.example.utnfinaljava.dtos.LocationDto;
import com.example.utnfinaljava.dtos.OrderDetailDto;
import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.entities.Location;
import com.example.utnfinaljava.entities.Order;
import com.example.utnfinaljava.entities.OrderDetail;
import com.example.utnfinaljava.entities.Price;
import com.example.utnfinaljava.entities.Product;
import com.example.utnfinaljava.entities.ProductSupplier;
import com.example.utnfinaljava.entities.Province;
@Configuration
public class ConfigurationModelMapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(ProvinceDto.class, Province.class);
        modelMapper.createTypeMap(CategoryDto.class, Category.class);

        modelMapper.createTypeMap(OrderDetail.class, OrderDetailDto.class)
            .addMappings(mapper -> {
                mapper.map(src -> src.getId().getProductId(), OrderDetailDto::setProductId);
                mapper.map(src -> src.getId().getOrderNumber(), OrderDetailDto::setOrderNumber);
                mapper.map(src -> src.getId().getIdPersona(), OrderDetailDto::setPersonaId);
            });

        modelMapper.createTypeMap(Price.class, PriceDto.class)
        .addMappings(mapper -> {
            mapper.map(src -> src.getId().getDateFrom(), PriceDto::setDateFrom);
        });
        
        var productoProveedorDtoMap = modelMapper.createTypeMap(ProductSupplier.class, ProductSupplierDto.class);
        productoProveedorDtoMap.addMappings(mapper -> {
            mapper.map(src -> src.getCantidad(), ProductSupplierDto::setAmount);
            mapper.map(src -> src.getProveedor().getBusinessName(), ProductSupplierDto:: setSupplierName);
            mapper.map(src -> src.getProveedor().getCuit(), ProductSupplierDto::setCuit);
            mapper.map(src -> src.getProducto().getDescription(), ProductSupplierDto::setProductName);
            mapper.map(src -> src.getProducto().getId(), ProductSupplierDto::setProductId);
            mapper.map(src -> src.getPrices(), ProductSupplierDto::setPrices);
            mapper.map(src -> src.getValidityPrice().getPrice(), ProductSupplierDto::setValidityPrice);
        });
        return modelMapper;
    }
}
