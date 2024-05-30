package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {
    void addCartItem(CartItemDTO cartItem);

    void removeCartItem(Long productId);

    void updateCartItemQuantity(Long productId, int quantity);

    List<CartItemDTO> getCartItems();

    void clearCart();
}
