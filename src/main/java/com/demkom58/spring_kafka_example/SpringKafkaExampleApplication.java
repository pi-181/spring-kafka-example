package com.demkom58.spring_kafka_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableKafka
@SpringBootApplication
public class SpringKafkaExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaExampleApplication.class, args);
    }
}
