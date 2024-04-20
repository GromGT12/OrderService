package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.repository.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
