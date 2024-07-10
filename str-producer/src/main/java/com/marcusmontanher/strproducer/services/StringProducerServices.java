package com.marcusmontanher.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerServices {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                    if (success != null) {
                        log.info("Send message with success: {}", message);
                        log.info("Partition: {}, Offset: {}", success.getRecordMetadata().partition(),
                                success.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Error send message")
        );
    }
}
