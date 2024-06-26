package com.sweet_bites_delivery_service.mappers;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemMapper {
    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    @Mapping(source = "shoppingCart.id", target = "shoppingCartId")
    CartItemDTO toCartItemDTO(CartItem cartItem);

    CartItem toCartItem(CartItemDTO cartItemDTO);
}
