package com.epam.ecommerceapp.controller;

import com.epam.ecommerceapp.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}/place-order")
    public ResponseEntity<String> placeOrder(@PathVariable Long userId) {
        orderService.createOrder(userId);
        return ResponseEntity.ok("Order placed successfully");
    }

}

