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

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final DeliveryValidator deliveryValidator;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper, DeliveryValidator deliveryValidator) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
        this.deliveryValidator = deliveryValidator;
    }

    @Override
    @Transactional(readOnly = true)
    public DeliveryDTO getDeliveryById(Long id) {
        Delivery delivery = (Delivery) deliveryRepository.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found with id: " + id));
        return deliveryMapper.toDeliveryDTO(delivery);
    }


    @Override
    @Transactional
    public void createDelivery(DeliveryDTO deliveryDTO) {
        deliveryValidator.validateDelivery(deliveryDTO);
        Delivery delivery = deliveryMapper.toDelivery(deliveryDTO);
        deliveryRepository.save(delivery);
    }

    @Override
    public void updateDelivery(DeliveryDTO deliveryDTO) {

    }

    @Override
    public void deleteDelivery(Integer id) {
        @Transactional
        public void deleteDelivery(Long id) {
            Delivery delivery = (Delivery) deliveryRepository.findById(id)
                    .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found with id: " + id));
            deliveryRepository.delete((DeliveryRepository) delivery);
    }

    @Override
    @Transactional
    public void updateDelivery(Long id, DeliveryDTO deliveryDTO) {
        deliveryValidator.validateDelivery(deliveryDTO);
        Delivery existingDelivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found with id: " + id));
        deliveryMapper.updateDeliveryFromDto(deliveryDTO, existingDelivery);
        deliveryRepository.save(existingDelivery);
    }


}
