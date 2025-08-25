package com.springboot.product_service.service;

import com.springboot.product_service.dto.ProductRequestDto;
import com.springboot.product_service.dto.ProductResponseDto;
import com.springboot.product_service.entiry.Category;
import com.springboot.product_service.entiry.Products;
import com.springboot.product_service.repository.CategoryRepository;
import com.springboot.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Category category = categoryRepository.findById(productRequestDto.getCategoryId()).orElseThrow(()-> new RuntimeException("category not found"));

        Products product = new Products();
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setQuantity(productRequestDto.getQuantity());
        product.setCategory(category);

        Products saveProduct = productRepository.save(product);
        ProductResponseDto productResponseDto = convertToDto(saveProduct);
        return productResponseDto;
    }

    @Override
    public ProductResponseDto getProductById(String productId) {
        Products products = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        ProductResponseDto productResponseDto = convertToDto(products);
        return productResponseDto;
    }

    @Override
    public ProductResponseDto updateProduct(String productId, ProductRequestDto productRequestDto) {
        Products products = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        products.setName(productRequestDto.getName());
        products.setDescription(productRequestDto.getDescription());
        products.setPrice(productRequestDto.getPrice());
        products.setQuantity(productRequestDto.getQuantity());
        productRepository.save(products);
        ProductResponseDto productResponseDto = convertToDto(products);
        return productResponseDto;
    }

    @Override
    public void deleteProducts(String productId) {
        Products products = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        productRepository.delete(products);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public ProductResponseDto updateStock(String productId, Integer stockQuantity) {
        Products products = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        products.setQuantity(stockQuantity);
        productRepository.save(products);
        ProductResponseDto productResponseDto = convertToDto(products);
        return productResponseDto;
    }


    private ProductResponseDto convertToDto(Products products){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(products.getProductId());
        productResponseDto.setName(products.getName());
        productResponseDto.setDescription(products.getDescription());
        productResponseDto.setQuantity(products.getQuantity());
        productResponseDto.setPrice(products.getPrice());
        productResponseDto.setInStock(products.getInStock());
        productResponseDto.setCategoryName(products.getCategory().getName());
        return productResponseDto;
    }
}
