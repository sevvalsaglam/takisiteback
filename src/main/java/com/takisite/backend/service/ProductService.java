package com.takisite.backend.service;

import com.takisite.backend.dto.ProductRequest;
import com.takisite.backend.dto.ProductResponse;
import com.takisite.backend.model.Product;
import com.takisite.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public ProductResponse getById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public List<ProductResponse> getByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<ProductResponse> search(String keyword) {
        return productRepository.findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public Product addProduct(ProductRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setCategory(request.getCategory());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setImage(request.getImage());
        product.setPoint(request.getPoint());

        return productRepository.save(product);
    }


    // Dönüşüm metodu (model → DTO)
    private ProductResponse convertToDto(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .category(product.getCategory())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .point(product.getPoint())
                .build();
    }
}
