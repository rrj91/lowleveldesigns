package com.scaler.kafkaproducer.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String topic,String message){
        kafkaTemplate.send(topic,message);
    }
}
