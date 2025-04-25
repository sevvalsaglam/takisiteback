package com.takisite.backend.service;

import com.takisite.backend.dto.FavoriteResponse;
import com.takisite.backend.model.Favorite;
import com.takisite.backend.model.User;
import com.takisite.backend.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<FavoriteResponse> getFavoritesByUser(User user) {
        List<Favorite> favoriteList = favoriteRepository.findByUser(user);
        List<FavoriteResponse> responseList = new ArrayList<>();

        for (Favorite fav : favoriteList) {
            FavoriteResponse response = new FavoriteResponse();
            response.setId(fav.getId());
            response.setProductId(fav.getProduct().getId());
            response.setTitle(fav.getProduct().getTitle());
            response.setImage(fav.getProduct().getImage());
            response.setPrice(fav.getProduct().getPrice());
            response.setCategory(fav.getProduct().getCategory());
            response.setPoint(fav.getProduct().getPoint());

            responseList.add(response);
        }

        return responseList;
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
