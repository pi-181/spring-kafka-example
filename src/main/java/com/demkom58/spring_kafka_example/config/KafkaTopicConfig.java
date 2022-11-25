package com.demkom58.spring_kafka_example.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to create a topic in Kafka programmatically
 * since it is only example. In real life, you usually create
 * a topic manually.
 * <p>
 * Here is an example:
 * ```bash
 * $ bin/kafka-topics.sh --create \
 *   --zookeeper localhost:2181 \
 *   --replication-factor 1 --partitions 1 \
 *   --topic notifications
 * ```
 */
@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic notificationsTopic() {
        /*
         * Partitions allow users to parallelize topics, meaning
         * data for any topic can be divided over multiple brokers.
         * A critical component of Kafka optimization is optimizing
         * the number of partitions in the implementation.
         */
        return new NewTopic("notifications", 1, (short) 1);
    }
}
