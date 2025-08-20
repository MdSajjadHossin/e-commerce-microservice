package com.springboot.product_service.dto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String categoryId;
}
