package io.mitochondria.inventory.confg;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic inventoryReservedTopic() {
        return TopicBuilder.name("inventory-reserved")
            .partitions(3)
            .replicas(3)
            .config(TopicConfig.RETENTION_MS_CONFIG, "86400000")
            .config(TopicConfig.RETENTION_BYTES_CONFIG, "524288000")
            .build();
    }

    @Bean
    public NewTopic inventoryRejectedTopic() {
        return TopicBuilder.name("inventory-rejected")
            .partitions(3)
            .replicas(3)
            .config(TopicConfig.RETENTION_MS_CONFIG, "86400000")
            .config(TopicConfig.RETENTION_BYTES_CONFIG, "524288000")
            .build();
    }
}