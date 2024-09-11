package com.example.kafka.Kafka;

import com.example.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @KafkaListener(topics="${spring.kafka.topic-json.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user){
//        spring kafka provided jsondeserializer will convert User json into java User object
        LOGGER.info(String.format("Json message Received -> %s ", user.toString()));
    }
}
