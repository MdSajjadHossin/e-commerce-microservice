package com.springboot.product_service.service;

import com.springboot.product_service.dto.CategoryRequestDto;
import com.springboot.product_service.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto getCategoryById(String categoryId);
    CategoryResponseDto updateCategory(String categoryId, CategoryRequestDto categoryRequestDto);
    List<CategoryResponseDto> getAllCategories();
    void deleteCategory(String categoryId);

}
