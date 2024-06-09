package com.sweet_bites_delivery_service.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class OrderProducer {

    private final static String TOPIC = "orders";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";

    private Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(props);
    }

    public void sendOrder(String orderId, String orderJson) {
        try (Producer<String, String> producer = createProducer()) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, orderId, orderJson);
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                } else {
                    System.out.printf("Order sent successfully. Topic: %s, Partition: %d, Offset: %d%n",
                            metadata.topic(), metadata.partition(), metadata.offset());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OrderProducer producer = new OrderProducer();
        producer.sendOrder("order1", "{\"item\": \"item1\", \"quantity\": 1}");
    }
}
