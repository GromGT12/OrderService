package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.mappers.CartItemMapper;
import com.sweet_bites_delivery_service.model.CartItem;
import com.sweet_bites_delivery_service.repository.CartItemRepository;
import com.sweet_bites_delivery_service.service.CartItemService;
import com.sweet_bites_delivery_service.validator.CartItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
    private final KafkaTemplate<String, CartItemDTO> kafkaTemplate;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartItemValidator cartItemValidator, CartItemMapper cartItemMapper, KafkaTemplate<String, CartItemDTO> kafkaTemplate) {
        this.cartItemRepository = cartItemRepository;
        this.cartItemValidator = cartItemValidator;
        this.cartItemMapper = cartItemMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void addCartItem(CartItemDTO cartItemDTO) {
        cartItemValidator.validateCartItem(cartItemDTO);
        CartItem cartItem = cartItemMapper.toCartItem(cartItemDTO);
        cartItemRepository.save(cartItem);

        kafkaTemplate.send("cart-item-topic", cartItemDTO);
    }

    @Override
    public void removeCartItem(Long productId) {
        CartItem cartItem = cartItemRepository.findByProductId(productId);
        if (cartItem != null) {
            cartItemRepository.delete(cartItem);
        }
    }

    @Override
    public void updateCartItemQuantity(Long productId, int quantity) {
        CartItem cartItem = cartItemRepository.findByProductId(productId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

    @Override
    public List<CartItemDTO> getCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();

        return cartItems.stream()
                .map(cartItemMapper::toCartItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void clearCart() {
        cartItemRepository.deleteAll();
    }
}
