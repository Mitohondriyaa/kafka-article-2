package io.mitochondria.analytics.service;

import io.mitochondria.inventory.event.InventoryRejectedEvent;
import io.mitochondria.inventory.event.InventoryReservedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    private static final Logger logger = LoggerFactory.getLogger(AnalyticsService.class);

    @KafkaListener(topics = "inventory-reserved")
    public void calculateMetricsIfReserved(InventoryReservedEvent inventoryReservedEvent) {
        logger.info("Received inventory reserved event: {}", inventoryReservedEvent);
    }

    @KafkaListener(topics = "inventory-rejected")
    public void calculateMetricsIfRejected(InventoryRejectedEvent inventoryRejectedEvent) {
        logger.info("Received inventory rejected event: {}", inventoryRejectedEvent);
    }
}