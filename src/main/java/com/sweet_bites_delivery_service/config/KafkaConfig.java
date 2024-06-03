package com.sweet_bites_delivery_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic cartItemTopic() {
        return TopicBuilder.name("cart-item-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic shoppingCartTopic() {
        return TopicBuilder.name("shopping-cart-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("order-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic deliveryTopic() {
        return TopicBuilder.name("delivery-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
