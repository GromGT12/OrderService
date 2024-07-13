package com.sweet_bites_delivery_service.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class DeliveryStatusConsumer {

    private static final String TOPIC = "delivery_status";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String GROUP_ID = "delivery-status-consumer-group";

    private Consumer<String, String> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return new KafkaConsumer<>(props);
    }

    public void consumeDeliveryStatus() {
        try (Consumer<String, String> consumer = createConsumer()) {
            consumer.subscribe(Collections.singletonList(TOPIC));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Received delivery status. Key: %s, Value: %s%n", record.key(), record.value());
                    // Здесь можно добавить логику обработки статуса доставки
                }
                consumer.commitAsync(); // Асинхронный коммит оффсетов
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeliveryStatusConsumer consumer = new DeliveryStatusConsumer();
        consumer.consumeDeliveryStatus();
    }
}
