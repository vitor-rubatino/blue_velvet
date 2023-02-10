package com.bluevelvet.web.repositories;

import com.bluevelvet.web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
