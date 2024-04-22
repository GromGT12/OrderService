package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.repository.CartItemRepository;
import com.sweet_bites_delivery_service.repository.mappers.CartItemMapper;
import com.sweet_bites_delivery_service.service.CartItemService;
import com.sweet_bites_delivery_service.validator.CartItemValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartItemValidator cartItemValidator;
    private final CartItemMapper cartItemMapper;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartItemValidator cartItemValidator, CartItemMapper cartItemMapper) {
        this.cartItemRepository = cartItemRepository;
        this.cartItemValidator = cartItemValidator;
        this.cartItemMapper = cartItemMapper;
    }


    @Override
    public void addCartItem(Long userId, CartItemDTO cartItem) {

    }

    @Override
    public void removeCartItem(Long userId, Long productId) {

    }

    @Override
    public void updateCartItemQuantity(Long userId, Long productId, int quantity) {

    }

    @Override
    public List<CartItemDTO> getCartItems(Long userId) {
        return null;
    }

    @Override
    public void clearCart(Long userId) {

    }
}
