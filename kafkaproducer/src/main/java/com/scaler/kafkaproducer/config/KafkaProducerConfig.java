package com.scaler.kafkaproducer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.kafkaproducer.models.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String,String> producerFactory(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public ProducerFactory<String,User> jsonProducerFactory(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String,String> getKafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaTemplate<String, User> getJsonKafkaTemplate(){
        return new KafkaTemplate<>(jsonProducerFactory());
    }

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
