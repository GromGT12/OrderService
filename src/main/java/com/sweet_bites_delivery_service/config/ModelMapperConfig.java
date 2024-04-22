package com.sweet_bites_delivery_service.config;

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
}
