package com.springboot.product_service.dto;

import lombok.Data;

@Data
public class CategoryResponseDto {

    private String categoryId;
    private String name;
    private String description;
}
