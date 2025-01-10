package com.scaler.kafkaconsumer.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "quickstart-events",groupId = "${group.id}")
    public void consumeMessage(String message){
        System.out.println("Message Received: "+message);
    }

    @KafkaListener(topics = "quickstart-events",groupId = "consumer-group-2")
    public void consumeMessage1(String message){
        System.out.println("Message Received1: "+message);
    }
}
