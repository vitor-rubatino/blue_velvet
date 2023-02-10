package com.bluevelvet.web.services;

import com.bluevelvet.web.entities.Product;
import com.bluevelvet.web.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product insert(Product product){
        boolean exist = productRepository.existsById(product.getId());
        if(!exist) {
            return productRepository.save(product);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role ja cadastrado");
    }
}
