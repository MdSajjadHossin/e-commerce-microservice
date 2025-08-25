package com.springboot.product_service.service;

import com.springboot.product_service.dto.CategoryRequestDto;
import com.springboot.product_service.dto.CategoryResponseDto;
import com.springboot.product_service.dto.ExtendedCategoryResponseDto;
import com.springboot.product_service.entiry.Category;
import com.springboot.product_service.entiry.Products;
import com.springboot.product_service.mapper.CategoryMapping;
import com.springboot.product_service.mapper.ProductMapping;
import com.springboot.product_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ExtendedCategoryResponseDto getCategoryById(String categoryId) {
            Category findCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));
            return convertToExtendedDto(findCategory);

    }

    @Override
    public CategoryResponseDto updateCategory(String categoryId, CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapping.toCategoryResponseDto(updatedCategory);
    }

    @Override
    public List<ExtendedCategoryResponseDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<ExtendedCategoryResponseDto> categoryResponseDto = new ArrayList<>();
        for (Category category : categories) {
            ExtendedCategoryResponseDto dto = convertToExtendedDto(category);
            categoryResponseDto.add(dto);
        }
        return categoryResponseDto;
    }


    @Override
    public void deleteCategory(String categoryId) {
        if(categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        }else {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
    }

    private ExtendedCategoryResponseDto convertToExtendedDto(Category category) {
        List<Products> productsList = category.getProducts();
        return new ExtendedCategoryResponseDto(
                category.getCategoryId(),
                category.getName(),
                category.getDescription(),
                productsList.stream().map(ProductMapping::toProductResponseDto).toList()

        );
    }
}
