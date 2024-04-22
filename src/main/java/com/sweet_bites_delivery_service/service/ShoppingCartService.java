package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.CartItemDTO;

import java.util.List;

public interface ShoppingCartService {
    void addCartItem(Long userId, Long productId, int quantity, double price);

    void removeCartItem(Long userId, Long productId);

    void updateCartItemQuantity(Long userId, Long productId, int quantity);

    List<CartItemDTO> getCartItems(Long userId);

    void clearCart(Long userId);

    void applyCoupon(Long userId, String couponCode);
}
