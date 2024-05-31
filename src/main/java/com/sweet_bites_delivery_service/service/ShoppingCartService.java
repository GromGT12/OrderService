package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.dto.ShoppingCartDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShoppingCartService {
    @Transactional
    void addCartItem(Long userId, CartItemDTO cartItemDTO);

    @Transactional
    void addCartItem(ShoppingCartDTO shoppingCartDTO, CartItemDTO cartItemDTO);

    @Transactional
    void removeCartItem(Long userId, Long productId);

    @Transactional
    void updateCartItemQuantity(Long userId, Long productId, Integer quantity);

    List<CartItemDTO> getCartItems(Long userId);

    @Transactional
    void clearCart(Long userId);
}
