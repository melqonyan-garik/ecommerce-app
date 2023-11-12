package com.epam.ecommerceapp.service;

import com.epam.ecommerceapp.model.*;
import com.epam.ecommerceapp.repository.OrderRepository;
import com.epam.ecommerceapp.repository.ProductRepository;
import com.epam.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    public void createOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        List<CartItem> cartItems = cartService.getCartItems(userId);

        // Create an order
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        // Calculate total amount and create order items
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();

            product.setInventoryQuantity(product.getInventoryQuantity() - quantity);
            productRepository.save(product);

            // Create order item
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

            totalAmount = totalAmount.add(orderItem.getSubtotal());

            order.getOrderItems().add(orderItem);
        }

        order.setTotalAmount(totalAmount);
        orderRepository.save(order);

    }
}
