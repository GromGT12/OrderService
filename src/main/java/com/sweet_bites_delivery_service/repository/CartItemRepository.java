package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.repository.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    void deleteByUserId(Long userId);

    CartItem findByUserIdOrProductID(Long userId, Long productId);

    List<CartItem> findByUserId(Long userId);
}
