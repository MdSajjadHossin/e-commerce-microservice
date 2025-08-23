package com.springboot.product_service.service;

import com.springboot.product_service.dto.CategoryRequestDto;
import com.springboot.product_service.dto.CategoryResponseDto;
import com.springboot.product_service.entiry.Category;
import com.springboot.product_service.mapper.CategoryMapping;
import com.springboot.product_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapping.toCategoryResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto getCategoryById(String categoryId) {
            Category findCategory = categoryRepository.findById(categoryId).orElse(null);
            if(findCategory != null){
                return CategoryMapping.toCategoryResponseDto(findCategory);
            }
        return null;
    }

    @Override
    public CategoryResponseDto updateCategory(String categoryId, CategoryRequestDto categoryRequestDto) {
        return null;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapping::toCategoryResponseDto)
                .toList();
    }

    @Override
    public void deleteCategory(String categoryId) {
        if(categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        }else {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
    }
}
