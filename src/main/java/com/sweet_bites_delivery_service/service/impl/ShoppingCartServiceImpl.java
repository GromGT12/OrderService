package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.repository.ShoppingCartRepository;
import com.sweet_bites_delivery_service.repository.mappers.ShoppingCartMapper;
import com.sweet_bites_delivery_service.service.ShoppingCartService;
import com.sweet_bites_delivery_service.validator.ShoppingCartValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartValidator shoppingCartValidator;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ShoppingCartValidator shoppingCartValidator, ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartValidator = shoppingCartValidator;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    public void addCartItem(Long userId, Long productId, int quantity, double price) {

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

    @Override
    public void applyCoupon(Long userId, String couponCode) {

    }
}
