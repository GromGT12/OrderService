package com.sweet_bites_delivery_service.config;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.dto.ShoppingCartDTO;
import com.sweet_bites_delivery_service.repository.mappers.DeliveryMapper;
import com.sweet_bites_delivery_service.repository.mappers.OrderMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public OrderMapper orderMapper() {
        return Mappers.getMapper(OrderMapper.class);
    }

    @Bean
    public DeliveryMapper deliveryMapper() {
        return Mappers.getMapper(DeliveryMapper.class);
    }

    @Bean
    public CartItemDTO cartItemDTO() {
        return Mappers.getMapper(CartItemDTO.class);
    }

    @Bean
    public ShoppingCartDTO shoppingCartDTO() {
        return Mappers.getMapper(ShoppingCartDTO.class);
    }
}
