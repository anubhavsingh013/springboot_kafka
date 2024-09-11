package com.example.kafka.Kafka;

import com.example.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
    // injecting kafka template to send message to the kafka topic
    private KafkaTemplate<String, User>kafkaTemplate;

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopicName;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User user){
        LOGGER.info(String.format("Json Message sent -> %s",user.toString()));
        Message<User>message= MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,jsonTopicName) // setting topic name in header
                .build();
        kafkaTemplate.send(message);
    }
}
