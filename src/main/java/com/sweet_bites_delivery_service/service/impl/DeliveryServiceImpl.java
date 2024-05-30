package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.exception.DeliveryNotFoundException;
import com.sweet_bites_delivery_service.mappers.DeliveryMapper;
import com.sweet_bites_delivery_service.model.Delivery;
import com.sweet_bites_delivery_service.repository.DeliveryRepository;
import com.sweet_bites_delivery_service.service.DeliveryService;
import com.sweet_bites_delivery_service.validator.DeliveryValidator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryValidator deliveryValidator;
    private final DeliveryMapper deliveryMapper;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryValidator deliveryValidator, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryValidator = deliveryValidator;
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public DeliveryDTO getDeliveryByOrderId(Long orderId) {
        Delivery delivery = deliveryRepository.findByOrderId(orderId);
        return delivery != null ? deliveryMapper.toDeliveryDTO(delivery) : null;
    }

    @Override
    @Transactional
    public DeliveryDTO createDelivery(DeliveryDTO deliveryDTO) {
        deliveryValidator.validatorDelivery(deliveryDTO);
        Delivery delivery = deliveryMapper.toDelivery(deliveryDTO);
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return deliveryMapper.toDeliveryDTO(savedDelivery);
    }

    @Override
    @Transactional
    public DeliveryDTO updateDelivery(@NotNull DeliveryDTO deliveryDTO) {
        Delivery existingDelivery = deliveryRepository.findById(deliveryDTO.getId())
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found with id: " + deliveryDTO.getId()));

        deliveryValidator.validatorDelivery(deliveryDTO);
        deliveryMapper.updateDeliveryFromDto(deliveryDTO, existingDelivery);
        Delivery updatedDelivery = deliveryRepository.save(existingDelivery);
        return deliveryMapper.toDeliveryDTO(updatedDelivery);
    }

    @Override
    @Transactional
    public DeliveryDTO deleteDeliveryByOrderId(Long orderId) {
        Delivery delivery = deliveryRepository.findByOrderId(orderId);
        if (delivery != null) {
            deliveryRepository.delete(delivery);
            return deliveryMapper.toDeliveryDTO(delivery);
        }
        return null;
    }

    @Override
    public List<DeliveryDTO> getDeliveriesByStatus(String deliveryStatus) {
        List<Delivery> deliveries = deliveryRepository.findByDeliveryStatus(deliveryStatus);
        return deliveries.stream()
                .map(deliveryMapper::toDeliveryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDTO> getDeliveriesByDateRange(Date startDate, Date endDate) {
        List<Delivery> deliveries = deliveryRepository.findByDeliveryDateBetween(startDate, endDate);
        return deliveries.stream()
                .map(deliveryMapper::toDeliveryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public int getDeliveryCountByStatus(String deliveryStatus) {
        return deliveryRepository.countByDeliveryStatus(deliveryStatus);
    }

    @Override
    public DeliveryDTO getDeliveryById(Long id) {
        return deliveryMapper.toDeliveryDTO(deliveryRepository.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found with id: " + id)));
    }

    @Override
    @Transactional
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}
