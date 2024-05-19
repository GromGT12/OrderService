package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.repository.CartItemRepository;
import com.sweet_bites_delivery_service.mappers.CartItemMapper;
import com.sweet_bites_delivery_service.model.CartItem;
import com.sweet_bites_delivery_service.service.CartItemService;
import com.sweet_bites_delivery_service.validator.CartItemValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public void addCartItem(Long userId, CartItemDTO cartItemDTO) {
        cartItemValidator.validateCartItem(cartItemDTO);
        CartItem cartItem = cartItemMapper.toCartItem(cartItemDTO);
        cartItem.setUserId(userId);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(Long userId, Long productId) {
        CartItem cartItem = cartItemRepository.findByUserIdOrProductID(userId, productId);
        if (cartItem != null) {
            cartItemRepository.delete(cartItem);
        }
    }

    @Override
    public void updateCartItemQuantity(Long userId, Long productId, int quantity) {
        CartItem cartItem = cartItemRepository.findByUserIdOrProductID(userId, productId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

    @Override
    public List<CartItemDTO> getCartItems(Long userId) {
        List<CartItem> cartItems = cartItemRepository.findByUserId(userId);

        return cartItems.stream()
                .map(cartItemMapper::toCartItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void clearCart(Long userId) {
        cartItemRepository.deleteByUserId(userId);
    }
}
