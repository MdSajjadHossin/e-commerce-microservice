package com.springboot.product_service.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private String productId;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Boolean inStock;
    private String categoryName;
}
