package com.sweet_bites_delivery_service.mappers;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.model.Delivery;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    @Mappings({
            @Mapping(source = "order.id", target = "orderId"), // Здесь изменено на orderId
    })
    DeliveryDTO toDeliveryDTO(Delivery delivery);

    Delivery toDelivery(DeliveryDTO deliveryDTO);

    @Mapping(target = "id", expression = "java(deliveryDTO.getOrderId())")
    Delivery updateDeliveryFromDto(DeliveryDTO deliveryDTO, @MappingTarget Delivery existingDelivery);

    DeliveryDTO toDeliveryDTOFromModel(Delivery delivery);
}
