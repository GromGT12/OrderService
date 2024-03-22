package com.sweet_bites_delivery_service.repository.mapper;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.repository.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    OrderDTO toOrderDTO(Order order);

    @Mapping(target = "id", ignore = true) // Игнорировать поле id при маппинге из OrderDTO в Order
    Order toOrder(OrderDTO orderDTO);
}
