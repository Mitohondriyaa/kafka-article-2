package io.mitochondria.inventory.repository;

import io.mitochondria.order.event.OrderPlacedEvent;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InventoryRepository {
    private final Map<String, Integer> inventory = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        inventory.put("Smartphone", 5);
        inventory.put("Tablet", 10);
        inventory.put("Desktop", 6);
    }

    public void deductStock(OrderPlacedEvent orderPlacedEvent) {
        Integer result = inventory.computeIfPresent(orderPlacedEvent.productName(), (name, quantity) -> {
            if (quantity < orderPlacedEvent.quantity()) {
                throw new RuntimeException("Quantity exceeded");
            }

            return quantity - orderPlacedEvent.quantity();
        });

        if (result == null) {
            throw new RuntimeException("Stock exceeded");
        }
    }
}