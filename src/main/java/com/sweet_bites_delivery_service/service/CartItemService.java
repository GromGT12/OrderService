package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartItemService {
    void addCartItem(Long userId, CartItemDTO cartItem);

    void removeCartItem(Long userId, Long productId);

    void updateCartItemQuantity(Long userId, Long productId, int quantity);

    List<CartItemDTO> getCartItems(Long userId);

    void clearCart(Long userId);
}
