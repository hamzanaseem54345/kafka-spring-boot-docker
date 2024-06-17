package com.hamzakafkalearning;


import com.hamzakafkalearning.config.KafkaTopicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private KafkaTopicConfig kafkaTopicConfig;

    public MessageController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        kafkaTopicConfig = new KafkaTopicConfig();
    }


    @PostMapping
    public void publishMessage(@RequestBody MessageRequest messageDTO)
    {
        kafkaTemplate.send(kafkaTopicConfig.kafkaTopic().name(),messageDTO.message());

    }

    @GetMapping()
    public String printMessage()
    {
        return "Welcome on docker port";
    }
}
