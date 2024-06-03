package com.sweet_bites_delivery_service.controller;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<Void> addCartItem(@RequestBody CartItemDTO cartItem) {
        cartItemService.addCartItem(cartItem);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long productId) {
        cartItemService.removeCartItem(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateCartItemQuantity(@PathVariable Long productId, @RequestParam int quantity) {
        cartItemService.updateCartItemQuantity(productId, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CartItemDTO>> getCartItems() {
        List<CartItemDTO> cartItems = cartItemService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearCart() {
        cartItemService.clearCart();
        return ResponseEntity.ok().build();
    }
}
