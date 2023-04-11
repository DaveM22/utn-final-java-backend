package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.entities.Producto;

public interface ProductoService {
    public List<Producto> listaProductos();

    public Producto guardarProducto(Producto categoria);

    public void borrarProducto(Long id);
}
