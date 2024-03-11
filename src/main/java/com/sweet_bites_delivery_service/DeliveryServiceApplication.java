package com.sweet_bites_delivery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.sweet_bites_delivery_service.repository.model")
@EnableJpaRepositories(basePackages = "com.sweet_bites_delivery_service.repository")
@SpringBootApplication
public class DeliveryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceApplication.class, args);

    }
}
