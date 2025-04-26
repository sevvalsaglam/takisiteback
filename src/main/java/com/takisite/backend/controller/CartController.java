package com.takisite.backend.controller;

import com.takisite.backend.dto.CartItemResponse;
import com.takisite.backend.model.CartItem;
import com.takisite.backend.model.User;
import com.takisite.backend.service.CartService;
import com.takisite.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = {
        "http://localhost:5175",
        "https://takisite-sevval-saglam.vercel.app"
})

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public List<CartItemResponse> getCart(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(cartService::getCartItemResponsesByUser)
                .orElse(List.of());
    }


    @PostMapping
    public CartItem addOrUpdate(@RequestBody CartItem item) {
        return cartService.saveCartItem(item);
    }

    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
    }

    @DeleteMapping("/clear/{email}")
    public void clearCart(@PathVariable String email) {
        userService.findByEmail(email).ifPresent(cartService::clearCart);
    }
}
