package com.demkom58.spring_kafka_example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
@Slf4j
public class Publisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final AtomicInteger counter = new AtomicInteger();

    @Scheduled(fixedRate = 1000)
    public void publish() {
        final String message = "Hello, world! #" + counter.incrementAndGet();
        kafkaTemplate.send("notifications", message)
                .addCallback(
                        result -> log.info("Message sent successfully: {}", message),
                        ex -> log.error("Error sending message: {}", message, ex)
                );
    }
}
