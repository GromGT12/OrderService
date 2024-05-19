package com.sweet_bites_delivery_service.config;

import com.sweet_bites_delivery_service.mappers.CartItemMapper;
import com.sweet_bites_delivery_service.mappers.DeliveryMapper;
import com.sweet_bites_delivery_service.mappers.OrderMapper;
import com.sweet_bites_delivery_service.mappers.ShoppingCartMapper;
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
    public CartItemMapper cartItemMapper() {
        return Mappers.getMapper(CartItemMapper.class);
    }

    @Bean
    public ShoppingCartMapper shoppingCartMapper() {
        return Mappers.getMapper(ShoppingCartMapper.class);
    }
}
