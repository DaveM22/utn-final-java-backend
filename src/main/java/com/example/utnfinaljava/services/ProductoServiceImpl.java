package com.example.utnfinaljava.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.ProductoDto;
import com.example.utnfinaljava.entities.Producto;
import com.example.utnfinaljava.entities.ProductoProveedor;
import com.example.utnfinaljava.interfaces.ProductoService;
import com.example.utnfinaljava.repositories.ProductoProveedorRepository;
import com.example.utnfinaljava.repositories.ProductoRepository;

import io.jsonwebtoken.lang.Arrays;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoProveedorRepository proveedorRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoDto> listaProductos() {

        var entities = productoRepository.findAll();
        var dtos = entities.stream()
        .map(a -> modelMapper.map(a, ProductoDto.class))
        .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public ProductoDto guardarProducto(ProductoDto producto) {
        Producto entity = modelMapper.map(producto, Producto.class);
        Producto nuevoProducto =  this.productoRepository.save(entity);
        ProductoDto dto = modelMapper.map(nuevoProducto, ProductoDto.class);
        return dto;
    }

    @Override
    public void borrarProducto(Long id) throws Exception {
        List<ProductoProveedor> productoProveedores = proveedorRepository.findByProductoId(id);
        if(!productoProveedores.isEmpty()){
            throw new Exception("Error al eliminar el producto, asegurese de eliminar todas los proveedores, precios y detalles de pedidos vinculados al producto y vuelva a intentarlo");
        }
        this.productoRepository.deleteById(id);
    }
    
}
