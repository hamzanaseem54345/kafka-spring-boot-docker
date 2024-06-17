package com.hamzakafkalearning;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaListener {


    @KafkaListener(topics = "myTopicLearning",groupId = "myGroupId")
    void Listen(Object data)
    {
        System.out.println("Listener received"+ data +":)");
    }
}
