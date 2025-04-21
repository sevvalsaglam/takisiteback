package com.takisite.backend.repository;

import com.takisite.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIgnoreCase(String category);
    List<Product> findByTitleContainingIgnoreCase(String keyword);
}
