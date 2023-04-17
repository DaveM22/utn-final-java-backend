package com.example.utnfinaljava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.utnfinaljava.entities.ProductoProveedor;
import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, ProductoProveedorId> {
    
    List<ProductoProveedor> findByProductoId(Long productoId);
}
