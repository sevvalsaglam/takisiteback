package com.takisite.backend.controller;

import com.takisite.backend.dto.CartItemResponse;
import com.takisite.backend.model.CartItem;
import com.takisite.backend.model.Product;
import com.takisite.backend.model.User;
import com.takisite.backend.service.CartService;
import com.takisite.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://takisite-sevval-saglam.vercel.app"
})

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<CartItemResponse> getCart(Authentication authentication) {
        String email = authentication.getName();
        return userService.findByEmail(email)
                .map(cartService::getCartItemResponsesByUser)
                .orElse(List.of());
    }



    @PostMapping
    public CartItem addOrUpdate(@RequestBody Map<String, Object> request, Authentication authentication) {
        String email = authentication.getName();
        Long productId = ((Number) request.get("productId")).longValue();
        Integer quantity = ((Number) request.get("quantity")).intValue();

        User user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        CartItem item = new CartItem();
        item.setUser(user);

        Product product = new Product();
        product.setId(productId);
        item.setProduct(product);

        item.setQuantity(quantity);

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
