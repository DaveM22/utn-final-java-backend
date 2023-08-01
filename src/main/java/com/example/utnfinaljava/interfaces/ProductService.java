package com.example.utnfinaljava.interfaces;

import java.util.List;
import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;


public interface ProductService {
    public List<ProductDto> getProducts();

    public ProductDto save(ProductDto product) throws AlreadyExistException;

    public ProductDto edit(ProductDto product) throws NotExistException;

    public void delete(Long id) throws NotExistException;
}
