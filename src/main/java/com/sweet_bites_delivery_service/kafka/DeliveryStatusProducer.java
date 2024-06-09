package com.sweet_bites_delivery_service.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class DeliveryStatusProducer {

    private static final String TOPIC = "delivery_status";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092"; // адрес и порт брокера Kafka

    private Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(props);
    }

    public void sendDeliveryStatus(String orderId, String statusJson) {
        try (Producer<String, String> producer = createProducer()) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, orderId, statusJson);
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                } else {
                    System.out.printf("Delivery status sent successfully. Topic: %s, Partition: %d, Offset: %d%n",
                            metadata.topic(), metadata.partition(), metadata.offset());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeliveryStatusProducer producer = new DeliveryStatusProducer();
        producer.sendDeliveryStatus("order1", "{\"status\": \"delivered\"}");
    }
}
