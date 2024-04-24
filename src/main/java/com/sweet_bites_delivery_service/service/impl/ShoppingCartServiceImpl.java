package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.repository.ShoppingCartRepository;
import com.sweet_bites_delivery_service.repository.mappers.ShoppingCartMapper;
import com.sweet_bites_delivery_service.repository.model.CartItem;
import com.sweet_bites_delivery_service.service.ShoppingCartService;
import com.sweet_bites_delivery_service.validator.ShoppingCartValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartValidator shoppingCartValidator;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ShoppingCartValidator shoppingCartValidator,
                                   ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartValidator = shoppingCartValidator;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    @Transactional
    public void addCartItem(Long userId, Long productId, Integer quantity, BigDecimal price) {
        // Проверяем корректность входных данных
        if (userId == null || productId == null || quantity == null || price == null) {
            throw new IllegalArgumentException("All parameters must be non-null");
        }

        // Убедимся, что quantity положительный
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        // Создание CartItem
        CartItem cartItem = new CartItem();
        cartItem.setUserId(userId);
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(price);

        // Сохранение в репозитории

    }


    @Override
    @Transactional
    public void removeCartItem(Long userId, Long productId) {
        CartItem cartItem = shoppingCartRepository.findByUserIdAndProductId(userId, productId);

        if (cartItem != null) {
            shoppingCartRepository.delete(cartItem.getShoppingCart());
        }
    }

    @Override
    @Transactional
    public void updateCartItemQuantity(Long userId, Long productId, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        CartItem cartItem = shoppingCartRepository.findByUserIdAndProductId(userId, productId);

        if (cartItem != null) {
            cartItem.setQuantity(quantity);

        }
    }

    @Override
    public List<Object> getCartItems(Long userId) {
        List<CartItem> cartItems = shoppingCartRepository.findByUserId(userId);

        return cartItems.stream()
                .map(shoppingCartMapper::toCartItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void clearCart(Long userId) {
        shoppingCartRepository.deleteByUserId(userId);
    }

}
