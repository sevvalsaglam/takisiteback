package com.takisite.backend.repository;

import com.takisite.backend.model.Favorite;
import com.takisite.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);
    void deleteAllByUser(User user);
}
