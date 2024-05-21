package com.sweet_bites_delivery_service.mappers;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "orderDate", target = "orderDate"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "deliveryAddress", target = "deliveryAddress"),
            @Mapping(source = "paymentStatus", target = "paymentStatus")
    })
    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDTO orderDTO);

    @Mappings({
            @Mapping(source = "orderDTO.id", target = "id"),
            @Mapping(source = "orderDTO.clientId", target = "clientId"),
            @Mapping(source = "orderDTO.orderDate", target = "orderDate"),
            @Mapping(source = "orderDTO.status", target = "status"),
            @Mapping(source = "orderDTO.deliveryAddress", target = "deliveryAddress"),
            @Mapping(source = "orderDTO.paymentStatus", target = "paymentStatus")
    })
    Order updateOrderFromDTO(OrderDTO orderDTO, @MappingTarget Order order);
}
