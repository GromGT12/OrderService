package com.sweet_bites_delivery_service.mappers;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.dto.ShoppingCartDTO;
import com.sweet_bites_delivery_service.model.CartItem;
import com.sweet_bites_delivery_service.model.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper {
    ShoppingCart toShoppingCart(ShoppingCartDTO shoppingCartDTO);

    ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart);

    CartItem toCartItem(CartItemDTO cartItemDTO);

    CartItemDTO toCartItemDTO(CartItem cartItem);
}
