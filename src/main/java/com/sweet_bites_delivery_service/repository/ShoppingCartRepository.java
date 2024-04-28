package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.repository.model.CartItem;
import com.sweet_bites_delivery_service.repository.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    CartItem findByUserIdAndProductId(Long userId, Long productId);

    List<CartItem> findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
