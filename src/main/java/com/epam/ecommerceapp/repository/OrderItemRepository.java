package com.epam.ecommerceapp.repository;

import com.epam.ecommerceapp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
