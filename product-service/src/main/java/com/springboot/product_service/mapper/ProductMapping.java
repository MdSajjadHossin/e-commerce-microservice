package com.springboot.product_service.mapper;

import com.springboot.product_service.dto.CategoryResponseDto;
import com.springboot.product_service.dto.ProductResponseDto;
import com.springboot.product_service.entiry.Category;
import com.springboot.product_service.entiry.Products;

public class ProductMapping {

    public static ProductResponseDto toProductResponseDto(Products products){
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setProductId(products.getProductId());
        responseDto.setName(products.getName());
        responseDto.setDescription(products.getDescription());
        responseDto.setPrice(products.getPrice());
        responseDto.setQuantity(products.getQuantity());
        responseDto.setInStock(products.getInStock());
        responseDto.setCategoryName(products.getCategory().getName());
        return responseDto;
    }

    public static Products toProductEntity(ProductResponseDto productResponseDto){
        Products products = new Products();
        products.setProductId(productResponseDto.getProductId());
        products.setName(productResponseDto.getName());
        products.setDescription(productResponseDto.getDescription());
        products.setPrice(productResponseDto.getPrice());
        products.setQuantity(productResponseDto.getQuantity());
        products.setInStock(productResponseDto.getInStock());
        return products;
    }
}
