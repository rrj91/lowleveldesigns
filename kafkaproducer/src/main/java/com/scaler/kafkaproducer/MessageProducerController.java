package com.scaler.kafkaproducer;

import com.scaler.kafkaproducer.component.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageProducerController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/topics/{topic}")
    @ResponseStatus(HttpStatus.OK)
    public void sendMessage(@PathVariable String topic, @RequestBody String message){
        messageProducer.sendMessage(topic,message);
    }
}
