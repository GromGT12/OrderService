package com.sweet_bites_delivery_service.mappers;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.model.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    @Mappings({
            @Mapping(source = "order.id", target = "orderId")
    })
    DeliveryDTO toDeliveryDTO(Delivery delivery);

    Delivery toDelivery(DeliveryDTO deliveryDTO);

    @Mapping(target = "id", ignore = true)
        // Игнорируем id, потому что он автогенерируемый
    void updateDeliveryFromDto(DeliveryDTO deliveryDTO, @MappingTarget Delivery existingDelivery);
}
