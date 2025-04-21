package com.takisite.backend.service;

import com.takisite.backend.model.CartItem;
import com.takisite.backend.model.User;
import com.takisite.backend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByUser(User user) {
        return cartItemRepository.findByUser(user);
    }

    public CartItem saveCartItem(CartItem item) {
        return cartItemRepository.save(item);
    }

    public void removeCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void clearCart(User user) {
        cartItemRepository.deleteAllByUser(user);
    }
}
