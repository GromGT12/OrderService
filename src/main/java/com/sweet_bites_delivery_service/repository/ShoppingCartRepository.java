package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
