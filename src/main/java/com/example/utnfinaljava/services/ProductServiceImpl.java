package com.example.utnfinaljava.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.ProductMapper;
import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.entities.Product;
import com.example.utnfinaljava.interfaces.ProductService;
import com.example.utnfinaljava.repositories.OrderDetailRepository;
import com.example.utnfinaljava.repositories.OrderRepository;
import com.example.utnfinaljava.repositories.ProductRepository;
import com.example.utnfinaljava.util.exceptions.NotExistException;
import com.example.utnfinaljava.util.exceptions.PersistenceException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final OrderDetailRepository orderDetailRepository;

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
        if(orderDetailRepository.existsByProductId(id)){
            throw new PersistenceException("No se puede borrar un producto que este integrado en un pedido");
        }
        this.productRepository.deleteById(id);
    }    
}
