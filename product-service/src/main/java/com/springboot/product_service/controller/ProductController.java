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
    public ProductResponseDto getProductById(@PathVariable String productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/allProducts")
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProducts(productId);
    }

    @PutMapping("/{productId}/updateStock")
    public ProductResponseDto updateStock(@PathVariable String productId, @RequestParam Integer stockQuantity){
        return productService.updateStock(productId, stockQuantity);
    }


}
