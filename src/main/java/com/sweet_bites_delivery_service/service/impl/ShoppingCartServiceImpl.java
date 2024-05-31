package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.dto.ShoppingCartDTO;
import com.sweet_bites_delivery_service.mappers.ShoppingCartMapper;
import com.sweet_bites_delivery_service.model.CartItem;
import com.sweet_bites_delivery_service.model.ShoppingCart;
import com.sweet_bites_delivery_service.repository.ShoppingCartRepository;
import com.sweet_bites_delivery_service.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final KafkaTemplate<String, CartItemDTO> kafkaTemplate;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ShoppingCartMapper shoppingCartMapper,
                                   KafkaTemplate<String, CartItemDTO> kafkaTemplate) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartMapper = shoppingCartMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public void addCartItem(Long userId, CartItemDTO cartItemDTO) {
        if (userId == null || cartItemDTO == null) {
            throw new IllegalArgumentException("UserId и CartItemDTO должны быть непустыми (non-null)");
        }
        kafkaTemplate.send("cart-item-topic", cartItemDTO);
    }

    @Override
    @Transactional
    public void addCartItem(ShoppingCartDTO shoppingCartDTO, CartItemDTO cartItemDTO) {
        if (shoppingCartDTO == null || cartItemDTO == null) {
            throw new IllegalArgumentException("ShoppingCartDTO и CartItemDTO должны быть непустыми (non-null)");
        }

        ShoppingCart shoppingCart = shoppingCartMapper.toShoppingCart(shoppingCartDTO);
        CartItem cartItem = shoppingCartMapper.toCartItem(cartItemDTO);

        cartItem.setShoppingCart(shoppingCart);
        shoppingCart.getItems().add(cartItem);

        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional
    public void removeCartItem(Long userId, Long productId) {
        CartItemDTO cartItemDTO = new CartItemDTO(userId, productId, 0, BigDecimal.ZERO);
        kafkaTemplate.send("cart-item-topic", cartItemDTO);
    }

    @Override
    @Transactional
    public void updateCartItemQuantity(Long userId, Long productId, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше нуля");
        }
        CartItemDTO cartItemDTO = new CartItemDTO(userId, productId, quantity, BigDecimal.ZERO);
        kafkaTemplate.send("cart-item-topic", cartItemDTO);
    }

    @Override
    public List<CartItemDTO> getCartItems(Long userId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId);
        return shoppingCart.getItems().stream()
                .map(shoppingCartMapper::toCartItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void clearCart(Long userId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId);
        if (shoppingCart != null) {
            shoppingCart.getItems().clear();
            shoppingCartRepository.save(shoppingCart);
        }
    }
}
