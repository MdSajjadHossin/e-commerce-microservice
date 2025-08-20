package com.springboot.product_service.service;

import com.springboot.product_service.dto.ProductRequestDto;
import com.springboot.product_service.dto.ProductResponseDto;
import com.springboot.product_service.entiry.Products;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto getProductById(String productId);
    ProductResponseDto updateProduct(ProductRequestDto productRequestDto);
    void deleteProducts(String productId);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto updateStock(String productId, Integer stockQuantity);



}
