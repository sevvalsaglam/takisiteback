package com.takisite.backend.service;

import com.takisite.backend.dto.FavoriteResponse;
import com.takisite.backend.model.Favorite;
import com.takisite.backend.model.User;
import com.takisite.backend.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<FavoriteResponse> getFavoritesByUser(User user) {
        return favoriteRepository.findByUser(user)
                .stream()
                .map(fav -> FavoriteResponse.builder()
                        .id(fav.getId())
                        .productId(fav.getProduct().getId())
                        .title(fav.getProduct().getTitle())
                        .image(fav.getProduct().getImage())
                        .price(fav.getProduct().getPrice())
                        .category(fav.getProduct().getCategory())
                        .point(fav.getProduct().getPoint())
                        .build()
                )
                .toList();
    }

    public Favorite saveFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    public void clearFavorites(User user) {
        favoriteRepository.deleteAllByUser(user);
    }
}
