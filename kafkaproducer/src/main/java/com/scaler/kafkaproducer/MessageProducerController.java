package com.scaler.kafkaproducer;

import com.scaler.kafkaproducer.component.MessageProducer;
import com.scaler.kafkaproducer.component.UserMessageProducer;
import com.scaler.kafkaproducer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageProducerController {

    @Autowired
    private MessageProducer stringMessageProducer;
    @Autowired
    private UserMessageProducer userMessageProducer;

    @PostMapping("/topics/{topic}")
    @ResponseStatus(HttpStatus.OK)
    public void sendMessage(@PathVariable String topic, @RequestBody String message){
        stringMessageProducer.sendMessage(topic,message);
    }

    @PostMapping("/topics/{topic}/users")
    @ResponseStatus(HttpStatus.OK)
    public void sendMessage(@PathVariable String topic, @RequestBody User user){
        userMessageProducer.sendMessage(topic,user);
    }
}
