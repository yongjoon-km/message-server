package com.example.messageserver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessagePushServiceTest {

    @Mock
    KafkaTemplate<String, String> kafkaTemplateMock;

    @InjectMocks
    MessagePushService service;

    @Test
    public void test_message_push_service() throws Exception {

        Message message = new Message("new message");

        service.pushMessage(message);

        verify(kafkaTemplateMock, times((1))).send("Message", message.getMessage());
    }
}