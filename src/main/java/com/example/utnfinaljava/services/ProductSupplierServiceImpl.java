package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    

    @Override
    public ProductSupplierListDto getProductSupplerByProductId(Long productoId) {

        Product producto = productoRepository.findById(productoId).get();
        List<ProductSupplier> entities = productoProveedorRepository.findByProductId(productoId);
        ProductSupplierListDto dto = new ProductSupplierListDto();
        List<ProductSupplierDto> detailsDto = new ArrayList<ProductSupplierDto>();
        for (ProductSupplier productSupplier : entities) {
            ProductSupplierDto psDto = new ProductSupplierDto();
            psDto.setAmount(productSupplier.getAmount());
            psDto.setCuit(productSupplier.getSupplier().getCuit());
            psDto.setPersonaId(productSupplier.getId().getIdPersona());
            psDto.setProductId(productSupplier.getId().getProducto());
            psDto.setProductName(productSupplier.getProduct().getDescription());
            psDto.setSupplierName(productSupplier.getSupplier().getBusinessName());
            psDto.setValidityPrice(productSupplier.getValidityPrice().getPrice());
            detailsDto.add(psDto);
        }
        dto.setProductName(producto.getDescription());
        dto.setProductSuppliers(detailsDto);
        return dto;
    }

    @Override
    public List<ProductSupplierDto> getProductSupplier() {
        List<ProductSupplier> entities = productoProveedorRepository.findAll();
        List<ProductSupplierDto> dtos = new ArrayList<ProductSupplierDto>();
        for (ProductSupplier productSupplier : entities) {
            ProductSupplierDto psDto = new ProductSupplierDto();
            psDto.setAmount(productSupplier.getAmount());
            psDto.setCuit(productSupplier.getSupplier().getCuit());
            psDto.setPersonaId(productSupplier.getId().getIdPersona());
            psDto.setProductId(productSupplier.getId().getProducto());
            psDto.setProductName(productSupplier.getProduct().getDescription());
            psDto.setSupplierName(productSupplier.getSupplier().getBusinessName());
            psDto.setValidityPrice(productSupplier.getValidityPrice().getPrice());
            dtos.add(psDto);
        }
        return dtos;
    }

    @Override
    @Transactional
    public ProductSupplierDto create(ProductSupplierDto supplier) throws AlreadyExistException {
       ProductoProveedorId id = new ProductoProveedorId();
       id.setIdPersona(supplier.getPersonaId());
       id.setProducto(supplier.getProductId());
       boolean alreadyExistSupplier = this.productoProveedorRepository.existsById(id);
       if(alreadyExistSupplier){
         throw new AlreadyExistException("El proveedor ingresado ya es actualmente un proveedor");
       }
       ProductSupplier newProductSupplier = new ProductSupplier();
       newProductSupplier.setAmount(supplier.getAmount());
       newProductSupplier.setId(new ProductoProveedorId());
       newProductSupplier.getId().setIdPersona(supplier.getPersonaId());
       newProductSupplier.getId().setProducto(supplier.getProductId());
       productoProveedorRepository.save(newProductSupplier);
       return supplier;
    }

    

 
    
    
}
