package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.entities.Product;
import com.example.utnfinaljava.entities.ProductSupplier;
import com.example.utnfinaljava.interfaces.ProductService;
import com.example.utnfinaljava.repositories.ProductSupplierRepository;
import com.example.utnfinaljava.repositories.ProductoRepository;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductoRepository productRepository;
    @Override
    public List<ProductDto> getProducts() {

        List<Product> entities = productRepository.findAll();
        List<ProductDto> dtos = new ArrayList<ProductDto>();
        for (Product product : entities) {
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setAmount(product.GetTotal());
            dto.setCategoryId(product.getCategoryId());
            dto.setCategoryName(product.getCategory().getName());
            dto.setDescription(product.getDescription());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto product) {
        Product pro = new Product();
        pro.setDescription(product.getDescription());
        pro.setCategoryId(product.getCategoryId());
        Product newProduct =  this.productRepository.save(pro);
        product.setId(newProduct.getId());
        return product;
    }

    @Override
    @Transactional
    public ProductDto edit(ProductDto product) throws NotExistException {
        boolean notExist = !productRepository.existsById(product.getId());
        if (notExist) {
            throw new NotExistException("El producto ingresado no existe");
        }
        Product pro = new Product();
        pro.setId(product.getId());
        pro.setDescription(product.getDescription());
        pro.setCategoryId(product.getCategoryId());
        this.productRepository.save(pro);
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
