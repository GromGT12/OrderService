package com.sweet_bites_delivery_service.repository.mappers;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.repository.model.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    DeliveryDTO toDeliveryDTO(Delivery delivery);

    Delivery toDelivery(DeliveryDTO deliveryDTO);

    @Mapping(target = "id", expression = "java(deliveryDTO.getOrderId())")
    Delivery updateDeliveryFromDto(DeliveryDTO deliveryDTO, @MappingTarget Delivery existingDelivery);

    DeliveryDTO toDeliveryDTOFromModel(Delivery delivery);
}