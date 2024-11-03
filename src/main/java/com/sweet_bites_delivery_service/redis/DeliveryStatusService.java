package com.sweet_bites_delivery_service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeliveryStatusService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveDeliveryStatus(String orderId, String status) {
        redisTemplate.opsForValue().set(orderId, status);
    }

    public Object getDeliveryStatus(String orderId) {
        return redisTemplate.opsForValue().get(orderId);
    }
}
