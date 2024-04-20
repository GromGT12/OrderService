package com.sweet_bites_delivery_service.repository.mappers;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.repository.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDTO orderDTO);

    OrderDTO toOrderDTOFromModel(Order order);
}
