package com.sweet_bites_delivery_service.service;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
public interface ShoppingCartService {
    @Transactional
    void addCartItem(Long userId, Long productId, Integer quantity, BigDecimal price);

    @Transactional
    void removeCartItem(Long userId, Long productId);

    @Transactional
    void updateCartItemQuantity(Long userId, Long productId, Integer quantity);

    List<Object> getCartItems(Long userId);

    @Transactional
    void clearCart(Long userId);

}