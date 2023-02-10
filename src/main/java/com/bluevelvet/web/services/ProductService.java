package com.bluevelvet.web.services;

import com.bluevelvet.web.entities.Product;
import com.bluevelvet.web.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product insert(Product product){
        return productRepository.save(product);
    }

}
