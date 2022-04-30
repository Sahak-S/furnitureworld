package com.example.furnitureworld.service;

import com.example.furnitureworld.entity.Product;
import com.example.furnitureworld.repository.ProductRepository;
import com.example.furnitureworld.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;
    @Test
    void addProduct() {
        Product product = new Product();
        product.setName("dddd");
        product.setDescription("dddd");
        product.setPrice(10);
        product.setProductImages(product.getProductImages());
        assertEquals(1,productRepository.count());
        Optional<Product> allById = productRepository.findAllById(product.getId());
        assertTrue(allById.isPresent());
        assertEquals("dddd",allById.get().getName());
    }
}