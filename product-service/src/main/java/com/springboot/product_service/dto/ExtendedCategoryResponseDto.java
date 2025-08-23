package com.springboot.product_service.dto;

import com.springboot.product_service.entiry.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ExtendedCategoryResponseDto extends CategoryResponseDto{
    List<ProductResponseDto> products;

    public ExtendedCategoryResponseDto(String categoryId, String name, String description, List<ProductResponseDto> productResponseDto) {
        super(categoryId, name, description);
        this.products = productResponseDto;
    }

}
