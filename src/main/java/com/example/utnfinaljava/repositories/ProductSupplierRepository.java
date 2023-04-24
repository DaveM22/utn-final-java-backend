package com.example.utnfinaljava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.utnfinaljava.entities.ProductSupplier;
import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, ProductoProveedorId> {
    
    List<ProductSupplier> findByProductoId(Long productoId);
}
