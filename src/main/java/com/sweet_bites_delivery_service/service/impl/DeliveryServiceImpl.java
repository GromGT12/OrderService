package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.exception.DeliveryNotFoundException;
import com.sweet_bites_delivery_service.mapper.DeliveryMapper;
import com.sweet_bites_delivery_service.repository.DeliveryRepository;
import com.sweet_bites_delivery_service.repository.model.Delivery;
import com.sweet_bites_delivery_service.service.DeliveryService;
import com.sweet_bites_delivery_service.validator.DeliveryValidator;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryValidator deliveryValidator, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryValidator = deliveryValidator;
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public DeliveryDTO getDeliveryByOrderId(Integer orderId) {
        Delivery delivery = deliveryRepository.findByOrderId(orderId);
        return delivery != null ? deliveryMapper.toDeliveryDTO(delivery) : null;
    }

    @Override
    @Transactional
    public DeliveryDTO createDelivery(DeliveryDTO deliveryDTO) {
        deliveryValidator.validate(deliveryDTO);
        Delivery delivery = deliveryMapper.toDelivery(deliveryDTO);
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return deliveryMapper.toDeliveryDTO(savedDelivery);
    }

    @Override
    @Transactional
    public DeliveryDTO updateDelivery(DeliveryDTO deliveryDTO) {
        Delivery existingDelivery = deliveryRepository.findById(Math.toIntExact(deliveryDTO.getId()))
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found with id: " + deliveryDTO.getId()));

        deliveryValidator.validate(deliveryDTO);
        deliveryMapper.updateDeliveryFromDto(deliveryDTO, existingDelivery);
        Delivery updatedDelivery = deliveryRepository.save(existingDelivery);
        return deliveryMapper.toDeliveryDTO(updatedDelivery);
    }

    @Override
    @Transactional
    public DeliveryDTO deleteDeliveryByOrderId(Integer orderId) {
        Delivery delivery = deliveryRepository.findByOrderId(orderId);
        if (delivery != null) {
            deliveryRepository.delete(delivery);
            return deliveryMapper.toDeliveryDTO(delivery);
        }
        return null;
    }

    @Override
    public List<DeliveryDTO> getDeliveriesByClientId(Integer clientId) {
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
    public List<DeliveryDTO> getDeliveriesByProductId(Integer productId) {
        List<Delivery> deliveries = deliveryRepository.findByProductId(productId);
        return deliveries.stream()
                .map(deliveryMapper::toDeliveryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDTO> getDeliveryCountByClientId(Long clientId) {
        List<Delivery> deliveries = deliveryRepository.findByClientId(Math.toIntExact(clientId));
        return deliveries.stream()
                .map(deliveryMapper::toDeliveryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public int getDeliveryCountByClientId(Integer clientId) {
        return deliveryRepository.countByClientId(clientId);
    }

    @Override
    public int getDeliveryCountByStatus(String deliveryStatus) {
        return deliveryRepository.countByDeliveryStatus(deliveryStatus);
    }

    @Override
    public DeliveryDTO getDeliveryById(Integer id) {
        return deliveryMapper.toDeliveryDTO(deliveryRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteDelivery(Integer id) {
        deliveryRepository.deleteById(id);
    }
}