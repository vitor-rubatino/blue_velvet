package com.bluevelvet.web.controllers;

import com.bluevelvet.web.entities.Product;
import com.bluevelvet.web.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/products")
    public ResponseEntity<Product> insert(@RequestBody Product product){
        productService.insert(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
