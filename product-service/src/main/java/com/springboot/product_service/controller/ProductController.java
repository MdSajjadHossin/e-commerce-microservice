package com.springboot.product_service.controller;

import com.springboot.product_service.dto.ProductRequestDto;
import com.springboot.product_service.dto.ProductResponseDto;
import com.springboot.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/createProduct")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/{productId}")
    public ProductResponseDto getProductById(String productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/allProducts")
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

}
