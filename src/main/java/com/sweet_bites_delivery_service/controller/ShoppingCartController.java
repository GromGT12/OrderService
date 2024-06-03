package com.sweet_bites_delivery_service.controller;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.dto.ShoppingCartDTO;
import com.sweet_bites_delivery_service.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/{userId}/items")
    public ResponseEntity<Void> addCartItem(@PathVariable Long userId, @RequestBody CartItemDTO cartItemDTO) {
        shoppingCartService.addCartItem(userId, cartItemDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/items")
    public ResponseEntity<Void> addCartItem(@RequestBody ShoppingCartDTO shoppingCartDTO, @RequestBody CartItemDTO cartItemDTO) {
        shoppingCartService.addCartItem(shoppingCartDTO, cartItemDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/items/{productId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long userId, @PathVariable Long productId) {
        shoppingCartService.removeCartItem(userId, productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/items/{productId}")
    public ResponseEntity<Void> updateCartItemQuantity(@PathVariable Long userId, @PathVariable Long productId, @RequestParam Integer quantity) {
        shoppingCartService.updateCartItemQuantity(userId, productId, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/items")
    public ResponseEntity<List<CartItemDTO>> getCartItems(@PathVariable Long userId) {
        List<CartItemDTO> cartItems = shoppingCartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/{userId}/items/clear")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        shoppingCartService.clearCart(userId);
        return ResponseEntity.ok().build();
    }
}
