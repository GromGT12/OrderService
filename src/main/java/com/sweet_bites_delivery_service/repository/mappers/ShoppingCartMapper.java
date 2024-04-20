package com.sweet_bites_delivery_service.repository.mappers;

import com.sweet_bites_delivery_service.dto.ShoppingCartDTO;
import com.sweet_bites_delivery_service.repository.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShoppingCartMapper {
    ShoppingCartMapper INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart);

    ShoppingCart toShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
