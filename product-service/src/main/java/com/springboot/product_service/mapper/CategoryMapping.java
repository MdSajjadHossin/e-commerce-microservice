package com.springboot.product_service.mapper;

import com.springboot.product_service.dto.CategoryResponseDto;
import com.springboot.product_service.entiry.Category;

public class CategoryMapping {

    public static CategoryResponseDto toCategoryResponseDto(Category category) {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setCategoryId(category.getCategoryId());
        responseDto.setName(category.getName());
        responseDto.setDescription(category.getDescription());
        return responseDto;
    }

    public static Category toCategoryEntity(CategoryResponseDto categoryResponseDto){
        Category category = new Category();
        category.setCategoryId(categoryResponseDto.getCategoryId());
        category.setDescription(categoryResponseDto.getDescription());
        category.setName(categoryResponseDto.getName());
        return category;
    }
}
