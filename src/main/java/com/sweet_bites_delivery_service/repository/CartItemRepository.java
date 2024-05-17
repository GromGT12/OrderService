package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteByUserId(Long userId);

    CartItem findByUserIdOrProductID(Long userId, Long productId);

    List<CartItem> findByUserId(Long userId);
}
