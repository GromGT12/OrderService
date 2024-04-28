package com.sweet_bites_delivery_service.repository.mappers;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.repository.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "deliveryAddress", target = "deliveryAddress")
    @Mapping(source = "paymentStatus", target = "paymentStatus")
    OrderDTO toOrderDTO(Order order);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "deliveryAddress", target = "deliveryAddress")
    @Mapping(source = "paymentStatus", target = "paymentStatus")
    Order toOrder(OrderDTO orderDTO);

    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "deliveryAddress", target = "deliveryAddress")
    @Mapping(source = "paymentStatus", target = "paymentStatus")
    void updateOrderFromDTO(@MappingTarget Order order, OrderDTO orderDTO);
}

/*
import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.repository.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDTO orderDTO);

    OrderDTO updateOrderFromDTO(Order order, OrderDTO orderDTO);
}

 */