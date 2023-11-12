package com.epam.ecommerceapp.controller;

import com.epam.ecommerceapp.model.CartItem;
import com.epam.ecommerceapp.model.CartItemRequest;
import com.epam.ecommerceapp.model.User;
import com.epam.ecommerceapp.service.CartService;
import com.epam.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Secured("ROLE_USER")
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @PostMapping("/{userId}/add-to-cart")
    public ResponseEntity<String> addToCart(@PathVariable Long userId, @RequestBody CartItemRequest cartItemRequest) {
        cartService.addToCart(userId, cartItemRequest);
        return ResponseEntity.ok("Item added to cart successfully");
    }

    @GetMapping("/{userId}/cart")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartService.getCartItems(userId);
    }

    @DeleteMapping("/{userId}/remove-from-cart/{cartItemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long userId, @PathVariable Long cartItemId) {
        cartService.removeFromCart(userId, cartItemId);
        return ResponseEntity.ok("Item removed from cart successfully");
    }
}
