package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.mappers.CartItemMapper;
import com.sweet_bites_delivery_service.model.CartItem;
import com.sweet_bites_delivery_service.repository.CartItemRepository;
import com.sweet_bites_delivery_service.service.CartItemService;
import com.sweet_bites_delivery_service.validator.CartItemValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CartItemServiceImpl implements CartItemService {

    private static final Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);

    private final CartItemRepository cartItemRepository;
    private final CartItemValidator cartItemValidator;
    private final CartItemMapper cartItemMapper;
    private final KafkaTemplate<String, CartItemDTO> kafkaTemplate;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartItemValidator cartItemValidator,
                               CartItemMapper cartItemMapper, KafkaTemplate<String, CartItemDTO> kafkaTemplate) {
        this.cartItemRepository = cartItemRepository;
        this.cartItemValidator = cartItemValidator;
        this.cartItemMapper = cartItemMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public void addCartItem(CartItemDTO cartItemDTO) {
        try {
            cartItemValidator.validateCartItem(cartItemDTO);
            CartItem cartItem = cartItemMapper.toCartItem(cartItemDTO);
            cartItemRepository.save(cartItem);

            kafkaTemplate.send("cart-item-topic", cartItemDTO);
            logger.info("Added cart item to Kafka topic: {}", cartItemDTO);
        } catch (Exception e) {
            logger.error("Error while adding cart item: {}", e.getMessage());
            throw new RuntimeException("Failed to add cart item", e);
        }
    }

    @Override
    @Transactional
    public void removeCartItem(Long productId) {
        try {
            CartItem cartItem = cartItemRepository.findByProductId(productId);
            if (cartItem != null) {
                cartItemRepository.delete(cartItem);
                logger.info("Removed cart item with productId: {}", productId);
            }
        } catch (Exception e) {
            logger.error("Error while removing cart item: {}", e.getMessage());
            throw new RuntimeException("Failed to remove cart item", e);
        }
    }

    @Override
    @Transactional
    public void updateCartItemQuantity(Long productId, int quantity) {
        try {
            CartItem cartItem = cartItemRepository.findByProductId(productId);
            if (cartItem != null) {
                cartItem.setQuantity(quantity);
                cartItemRepository.save(cartItem);
                logger.info("Updated cart item quantity: productId={}, quantity={}", productId, quantity);
            }
        } catch (Exception e) {
            logger.error("Error while updating cart item quantity: {}", e.getMessage());
            throw new RuntimeException("Failed to update cart item quantity", e);
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
    @Transactional
    public void clearCart() {
        try {
            cartItemRepository.deleteAll();
            logger.info("Cleared the cart");
        } catch (Exception e) {
            logger.error("Error while clearing the cart: {}", e.getMessage());
            throw new RuntimeException("Failed to clear cart", e);
        }
    }
}
