package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {
    void addCartItem(Long userId, CartItemDTO cartItem);

    void removeCartItem(Long userId, Long productId);

    void updateCartItemQuantity(Long userId, Long productId, int quantity);

    List<CartItemDTO> getCartItems(Long userId);

    void clearCart(Long userId);
}
