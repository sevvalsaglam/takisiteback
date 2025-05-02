package com.takisite.backend.controller;

import com.takisite.backend.dto.FavoriteResponse;
import com.takisite.backend.model.Favorite;
import com.takisite.backend.model.Product;
import com.takisite.backend.model.User;
import com.takisite.backend.service.FavoriteService;
import com.takisite.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://takisite-sevval-saglam.vercel.app"
})

public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<FavoriteResponse> getFavorites(Authentication authentication) {
        String email = authentication.getName();
        return userService.findByEmail(email)
                .map(favoriteService::getFavoritesByUser)
                .orElse(List.of());
    }



    @PostMapping
    public Favorite addFavorite(@RequestBody Map<String, Long> request, Authentication authentication) {
        String email = authentication.getName();
        Long productId = request.get("productId");

        User user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);

        Product product = new Product();
        product.setId(productId);
        favorite.setProduct(product);

        return favoriteService.saveFavorite(favorite);
    }


    @DeleteMapping("/{id}")
    public void removeFavorite(@PathVariable Long id) {
        favoriteService.deleteFavorite(id);
    }

    @DeleteMapping("/clear/{email}")
    public void clearFavorites(@PathVariable String email) {
        userService.findByEmail(email).ifPresent(favoriteService::clearFavorites);
    }
}
