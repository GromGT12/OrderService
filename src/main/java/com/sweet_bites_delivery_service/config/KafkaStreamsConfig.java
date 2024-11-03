package com.sweet_bites_delivery_service.config;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

import java.util.Objects;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfig {

    @Bean
    public KStream<String, String> kStream(StreamsBuilderFactoryBean factory) throws Exception {
        KStream<String, String> stream = Objects.requireNonNull(factory.getObject()).stream("input-topic");
        stream.mapValues(value -> value.toUpperCase())
                .to("output-topic");
        return stream;
    }
}
