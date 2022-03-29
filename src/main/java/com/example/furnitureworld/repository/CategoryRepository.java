package com.example.furnitureworld.repository;

import com.example.furnitureworld.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
