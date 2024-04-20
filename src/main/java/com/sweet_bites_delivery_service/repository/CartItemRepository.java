package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.repository.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
