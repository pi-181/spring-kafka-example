package com.demkom58.spring_kafka_example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
    @KafkaListener(topics = "notifications", groupId = "test-group")
    public void handleNotification(String message) {
        log.info(
                "Received Message in group 'test-group' " +
                "from topic 'notifications': {}", message);
    }
}
