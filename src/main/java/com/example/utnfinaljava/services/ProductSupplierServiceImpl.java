package com.example.utnfinaljava.services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.dtos.ProductoProveedorListaDto;
import com.example.utnfinaljava.entities.Product;
import com.example.utnfinaljava.entities.ProductSupplier;
import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;
import com.example.utnfinaljava.interfaces.ProductSupplierService;
import com.example.utnfinaljava.repositories.ProductSupplierRepository;
import com.example.utnfinaljava.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {

    @Autowired
    private ProductSupplierRepository productoProveedorRepository;

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductoProveedorListaDto ListaProductosProveedor(Long productoId) {

        Product producto = productoRepository.findById(productoId).get();
        List<ProductSupplier> entities = productoProveedorRepository.findByProductoId(productoId);
        List<ProductSupplierDto> dtos = entities.stream()
        .map(a -> modelMapper.map(a, ProductSupplierDto.class))
        .collect(Collectors.toList());
        ProductoProveedorListaDto proveedorListaDto = new ProductoProveedorListaDto();
        proveedorListaDto.setNombreProducto(producto.getDescripcion());
        proveedorListaDto.setProductoProveedores(dtos);
        return proveedorListaDto;
    }

    @Override
    public List<ProductSupplierDto> listaProductoProveedor() {
        List<ProductSupplier> entities = productoProveedorRepository.findAll();
        List<ProductSupplierDto> dtos = entities.stream()
        .map(a -> modelMapper.map(a, ProductSupplierDto.class))
        .collect(Collectors.toList());
        return dtos;
    }

    @Override
    @Transactional
    public ProductSupplierDto AddProductSupplier(ProductSupplierDto supplier) {
       ProductSupplier newProductSupplier = new ProductSupplier();
       newProductSupplier.setCantidad(supplier.getAmount());
       newProductSupplier.setId(new ProductoProveedorId());
       newProductSupplier.getId().setIdPersona(supplier.getPersonaId());
       newProductSupplier.getId().setProducto(supplier.getProductId());
       productoProveedorRepository.save(newProductSupplier);
       return supplier;
    }

    

 
    
    
}
