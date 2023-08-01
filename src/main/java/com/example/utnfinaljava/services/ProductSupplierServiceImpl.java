package com.example.utnfinaljava.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.ProductSupplierMapper;
import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.dtos.ProductSupplierListDto;
import com.example.utnfinaljava.entities.Product;
import com.example.utnfinaljava.entities.ProductSupplier;
import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;
import com.example.utnfinaljava.interfaces.ProductSupplierService;
import com.example.utnfinaljava.repositories.ProductSupplierRepository;
import com.example.utnfinaljava.repositories.ProductRepository;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductSupplierServiceImpl implements ProductSupplierService {

    private final ProductSupplierRepository productoProveedorRepository;

    private final ProductRepository productoRepository;

    private final ProductSupplierMapper productSupplierMapper;
    

    @Override
    public ProductSupplierListDto getProductSupplerByProductId(Long productoId) {

        Product producto = productoRepository.findById(productoId).get();
        List<ProductSupplier> entities = productoProveedorRepository.findByProductId(productoId);
        ProductSupplierListDto dto = new ProductSupplierListDto();
        List<ProductSupplierDto> detailsDto = productSupplierMapper.productSupplierListToProductSupplierListDto(entities);
        dto.setProductSuppliers(detailsDto);
        dto.setProductName(producto.getDescription());
        dto.setProductSuppliers(detailsDto);
        return dto;
    }

    @Override
    public List<ProductSupplierDto> getProductSupplier() {
        List<ProductSupplier> entities = productoProveedorRepository.findAll();
        List<ProductSupplierDto> dtos = productSupplierMapper.productSupplierListToProductSupplierListDto(entities);
        return dtos;
    }

    @Override
    @Transactional
    public ProductSupplierDto create(ProductSupplierDto supplier) throws AlreadyExistException {
       ProductoProveedorId id = new ProductoProveedorId();
       id.setPersonaId(supplier.getPersonaId());
       id.setProductId(supplier.getProductId());
       boolean alreadyExistSupplier = this.productoProveedorRepository.existsById(id);
       if(alreadyExistSupplier){
         throw new AlreadyExistException("El proveedor ingresado ya es actualmente un proveedor");
       }
       ProductSupplier newProductSupplier = productSupplierMapper.productSupplierDtoToProductSupplier(supplier);
       ProductSupplier saved = productoProveedorRepository.save(newProductSupplier);
       return supplier;
    }

    @Override
    @Transactional
    public ProductSupplierDto edit(ProductSupplierDto supplier) {
       ProductoProveedorId id = new ProductoProveedorId();
       id.setPersonaId(supplier.getPersonaId());
       id.setProductId(supplier.getProductId());
       ProductSupplier newProductSupplier = productSupplierMapper.productSupplierDtoToProductSupplier(supplier);
       ProductSupplier saved = productoProveedorRepository.save(newProductSupplier);
       return supplier;
    }

    

    

 
    
    
}
