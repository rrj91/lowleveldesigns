package com.scaler.kafkaproducer.component;

import com.scaler.kafkaproducer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessageProducer {

    @Autowired
    @Qualifier("getJsonKafkaTemplate")
    private KafkaTemplate<String, User> userKafkaTemplate;

    public void sendMessage(String topic,User user){
        userKafkaTemplate.send(topic,user);
    }
}
