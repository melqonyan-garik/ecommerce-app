package com.epam.ecommerceapp.repository;

import com.epam.ecommerceapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
