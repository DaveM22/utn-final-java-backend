package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.utnfinaljava.entities.Producto;
import com.example.utnfinaljava.interfaces.ProductoService;
import com.example.utnfinaljava.repositories.ProductoRepository;

public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarProducto'");
    }

    @Override
    public void borrarProducto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarProducto'");
    }
    
}
