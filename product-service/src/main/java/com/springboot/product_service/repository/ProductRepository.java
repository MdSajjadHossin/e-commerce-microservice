package com.springboot.product_service.repository;

import com.springboot.product_service.entiry.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, String> {
}
