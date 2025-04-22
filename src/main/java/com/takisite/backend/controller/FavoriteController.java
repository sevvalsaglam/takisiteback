package com.takisite.backend.controller;

import com.takisite.backend.model.Favorite;
import com.takisite.backend.model.User;
import com.takisite.backend.service.FavoriteService;
import com.takisite.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = "http://localhost:5175")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public List<Favorite> getFavorites(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(favoriteService::getFavoritesByUser)
                .orElse(List.of());
    }

    @PostMapping
    public Favorite addFavorite(@RequestBody Favorite favorite) {
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
