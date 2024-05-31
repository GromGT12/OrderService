package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByProductId(Long productId);
}
