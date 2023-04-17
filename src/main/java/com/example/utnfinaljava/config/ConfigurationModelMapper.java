package com.example.utnfinaljava.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.utnfinaljava.dtos.CategoriaDto;
import com.example.utnfinaljava.dtos.LocalidadDto;
import com.example.utnfinaljava.dtos.ProductoDto;
import com.example.utnfinaljava.dtos.ProductoProveedorDto;
import com.example.utnfinaljava.dtos.ProvinciaDto;
import com.example.utnfinaljava.entities.Categoria;
import com.example.utnfinaljava.entities.Localidad;
import com.example.utnfinaljava.entities.Producto;
import com.example.utnfinaljava.entities.ProductoProveedor;
import com.example.utnfinaljava.entities.Provincia;
@Configuration
public class ConfigurationModelMapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(ProvinciaDto.class, Provincia.class);
        modelMapper.createTypeMap(LocalidadDto.class, Localidad.class);
        modelMapper.createTypeMap(CategoriaDto.class, Categoria.class);
        
        
        var productoDtoMap = modelMapper.createTypeMap(Producto.class, ProductoDto.class);
        productoDtoMap.addMappings(mapper -> {
            mapper.map(src -> src.getId(), ProductoDto::setId);
            mapper.map(src -> src.getDescripcion(), ProductoDto::setDescripcion);
            mapper.map(src -> src.getCategoria().getNombre(), ProductoDto::setCategoria);
            mapper.map(src -> src.GetTotal(), ProductoDto::setCantidad);
        });

        var productoProveedorDtoMap = modelMapper.createTypeMap(ProductoProveedor.class, ProductoProveedorDto.class);
        productoProveedorDtoMap.addMappings(mapper -> {
            mapper.map(src -> src.getCantidad(), ProductoProveedorDto::setCantidad);
            mapper.map(src -> src.getProveedor().getRazonSocial(), ProductoProveedorDto::setNombreProveedor);
            mapper.map(src -> src.getProveedor().getCuit(), ProductoProveedorDto::setCuit);
            mapper.map(src -> src.getProducto().getId(), ProductoProveedorDto::setIdProducto);
        });
        return modelMapper;
    }
}
