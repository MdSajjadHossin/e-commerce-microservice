package com.springboot.product_service.configuration;

public class IdGenerator {

    private static int categoryCounter = 0;
    private static int productCounter = 0;

    public static synchronized int generateCategoryId(){
        categoryCounter++;
        return categoryCounter;
    }

    public static synchronized int generateProductId(){
        productCounter++;
        return productCounter;
    }
}
