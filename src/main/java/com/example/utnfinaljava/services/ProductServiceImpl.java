package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.ProductMapper;
import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.entities.Product;
import com.example.utnfinaljava.interfaces.ProductService;
import com.example.utnfinaljava.repositories.ProductRepository;
import com.example.utnfinaljava.util.exceptions.NotExistException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getProducts() {
        List<Product> entities = productRepository.findAll();
        return productMapper.ProductListToProductDtoList(entities);
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto product) {
        Product pro = productMapper.ProductDtoToProduct(product);
        Product save = productRepository.save(pro);
        product = productMapper.ProductToProductDto(save);
        return product;
    }

    @Override
    @Transactional
    public ProductDto edit(ProductDto product) throws NotExistException {
        boolean notExist = !productRepository.existsById(product.getId());
        if (notExist) {
            throw new NotExistException("El producto ingresado no existe");
        }
        Product pro = productMapper.ProductDtoToProduct(product);
        Product save = productRepository.save(pro);
        product = productMapper.ProductToProductDto(save);
        return product;
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotExistException {
        boolean notExist = !productRepository.existsById(id);
        if(notExist){
            throw new NotExistException("El producto ingresado no existe");
        }
        this.productRepository.deleteById(id);
    }    
}
