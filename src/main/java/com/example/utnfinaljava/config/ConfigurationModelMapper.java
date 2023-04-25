package com.example.utnfinaljava.config;

import java.util.Locale.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.utnfinaljava.dtos.CategoriaDto;
import com.example.utnfinaljava.dtos.LocalidadDto;
import com.example.utnfinaljava.dtos.OrderDetailDto;
import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.dtos.ProductoDto;
import com.example.utnfinaljava.dtos.ProductoProveedorDto;
import com.example.utnfinaljava.dtos.ProvinciaDto;
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
        modelMapper.createTypeMap(ProvinciaDto.class, Province.class);
        modelMapper.createTypeMap(LocalidadDto.class, Location.class);
        modelMapper.createTypeMap(CategoriaDto.class, Category.class);

        modelMapper.createTypeMap(OrderDetail.class, OrderDetailDto.class)
            .addMappings(mapper -> {
                mapper.map(src -> src.getId().getProductId(), OrderDetailDto::setProductId);
                mapper.map(src -> src.getId().getOrderNumber(), OrderDetailDto::setOrderNumber);
                mapper.map(src -> src.getId().getCuit(), OrderDetailDto::setCuit);
            });

        modelMapper.createTypeMap(Order.class, OrderDto.class)
        .addMappings(mapper -> {
            mapper.map(src -> src.getCustomer().getCuit(), OrderDto::setCustomerCuit);
            mapper.map(src -> src.getCustomer().getRazonSocial(), OrderDto::setCustomer);
            mapper.map(src -> src.getDetails(), OrderDto::setDetails);
            mapper.map(src -> src.GetTotalAmount(), OrderDto::setTotalAmount);
        });

        modelMapper.createTypeMap(Price.class, PriceDto.class)
        .addMappings(mapper -> {
            mapper.map(src -> src.getId().getDateFrom(), PriceDto::setDateFrom);
        });
        
        var productoDtoMap = modelMapper.createTypeMap(Product.class, ProductoDto.class);
        productoDtoMap.addMappings(mapper -> {
            mapper.map(src -> src.getId(), ProductoDto::setId);
            mapper.map(src -> src.getDescripcion(), ProductoDto::setDescripcion);
            mapper.map(src -> src.getCategoria().getNombre(), ProductoDto::setCategoria);
            mapper.map(src -> src.GetTotal(), ProductoDto::setCantidad);
        });

        var productoProveedorDtoMap = modelMapper.createTypeMap(ProductSupplier.class, ProductoProveedorDto.class);
        productoProveedorDtoMap.addMappings(mapper -> {
            mapper.map(src -> src.getCantidad(), ProductoProveedorDto::setCantidad);
            mapper.map(src -> src.getProveedor().getRazonSocial(), ProductoProveedorDto::setNombreProveedor);
            mapper.map(src -> src.getProveedor().getCuit(), ProductoProveedorDto::setCuit);
            mapper.map(src -> src.getProducto().getDescripcion(), ProductoProveedorDto::setProductName);
            mapper.map(src -> src.getProducto().getId(), ProductoProveedorDto::setIdProducto);
            mapper.map(src -> src.getPrices(), ProductoProveedorDto::setPrices);
            mapper.map(src -> src.getValidityPrice().getPrice(), ProductoProveedorDto::setValidityPrice);
        });
        return modelMapper;
    }
}
