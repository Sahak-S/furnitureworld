package com.example.furnitureworld.service;

import com.example.furnitureworld.entity.Product;
import com.example.furnitureworld.entity.User;
import com.example.furnitureworld.entity.UserType;
import com.example.furnitureworld.repository.ProductRepository;
import com.example.furnitureworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
