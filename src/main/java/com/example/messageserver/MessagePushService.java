package com.example.messageserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePushService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void pushMessage(Message message) throws Exception {
        kafkaTemplate.send("Message", message.getMessage());
    }

}
