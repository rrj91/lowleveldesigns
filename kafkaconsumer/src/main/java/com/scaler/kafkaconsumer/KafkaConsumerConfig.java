package com.scaler.kafkaconsumer;

import com.scaler.kafkaproducer.models.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${group.id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, String> getConsumerFactory(){
        System.out.println("Group: "+groupId);
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }
    @Bean
    public ConsumerFactory<String, User> getJsonConsumerFactory(){
        System.out.println("Group: "+groupId);
        JsonDeserializer<User> deserializer = new JsonDeserializer();
        deserializer.addTrustedPackages("com.scaler.kafkaproducer.models");
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),deserializer);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String > getContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(getConsumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,User > getJsonContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,User> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(getJsonConsumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }
}
