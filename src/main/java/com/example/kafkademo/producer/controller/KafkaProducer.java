package com.example.kafkademo.producer.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping(value = "/producer")
public class KafkaProducer
{
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "/health")
    public String health() {
        return "Service is Up & Running. " + Instant.now().toString();
    }

    @PostMapping(value="/{topic}/send-message")
    public String sendMessage(@PathVariable("topic") String topic, @RequestBody Message request){
        kafkaTemplate.send(topic,request.getKey(), request.getValue() );
        return "posted message key: "+ request.getKey() + " value:"+ request.getValue();
    }

}
@Data
class Message{
    private String key = null;

    private String value = null;
}