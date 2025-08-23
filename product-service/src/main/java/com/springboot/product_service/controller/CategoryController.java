package com.springboot.product_service.controller;

import com.springboot.product_service.dto.CategoryRequestDto;
import com.springboot.product_service.dto.CategoryResponseDto;
import com.springboot.product_service.dto.ExtendedCategoryResponseDto;
import com.springboot.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/createCategory")
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return categoryService.createCategory(categoryRequestDto);
    }

    @GetMapping("/")
    public List<ExtendedCategoryResponseDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public CategoryResponseDto getCategoryById(@PathVariable String categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @DeleteMapping("/delete/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId){
        categoryService.deleteCategory(categoryId);
    }


}
