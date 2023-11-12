package com.epam.ecommerceapp.service;

import com.epam.ecommerceapp.model.CartItem;
import com.epam.ecommerceapp.model.CartItemRequest;
import com.epam.ecommerceapp.model.Product;
import com.epam.ecommerceapp.model.User;
import com.epam.ecommerceapp.repository.ProductRepository;
import com.epam.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(Long userId, CartItemRequest cartItemRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        Product product = productRepository.findById(cartItemRequest.getProductId())
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + cartItemRequest.getProductId()));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemRequest.getQuantity());

        user.getCartItems().add(cartItem);
        userRepository.save(user);
    }

    public List<CartItem> getCartItems(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        return user.getCartItems();
    }

    public void removeFromCart(Long userId, Long cartItemId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        user.getCartItems().removeIf(cartItem -> cartItem.getId().equals(cartItemId));
        userRepository.save(user);
    }
}
