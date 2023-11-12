package com.epam.ecommerceapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemRequest {

    private Long productId;
    private int quantity;

    // Getters and setters
}

