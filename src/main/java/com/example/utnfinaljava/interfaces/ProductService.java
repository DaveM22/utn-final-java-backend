package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.ProductoDto;


public interface ProductService {
    public List<ProductoDto> listaProductos();

    public ProductoDto guardarProducto(ProductoDto producto);

    public void borrarProducto(Long id) throws Exception;
}
