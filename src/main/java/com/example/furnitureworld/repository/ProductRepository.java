package com.example.furnitureworld.repository;

import com.example.furnitureworld.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
