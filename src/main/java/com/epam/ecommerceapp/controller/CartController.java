package com.epam.ecommerceapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/add-to-cart")
    public ResponseEntity<String> addToCart(@PathVariable Long userId, @RequestBody CartItemRequest cartItemRequest) {
        // Validate input, process the request, and return an appropriate response
        cartService.addToCart(userId, cartItemRequest);
        return ResponseEntity.ok("Item added to cart successfully");
    }

    @GetMapping("/{userId}/cart")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartService.getCartItems(userId);
    }

    @DeleteMapping("/{userId}/remove-from-cart/{productId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        // Validate input, process the request, and return an appropriate response
        cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok("Item removed from cart successfully");
    }
}
