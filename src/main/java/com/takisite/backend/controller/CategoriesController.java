package com.takisite.backend.controller;

import com.takisite.backend.model.Categories;
import com.takisite.backend.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5175")  // React frontend için CORS ayarları
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    // Tüm kategorileri listele
    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }
}
