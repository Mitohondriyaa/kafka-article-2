package io.mitochondria.order.event;

public record OrderPlacedEvent(String orderId, String email, String productName, Integer quantity) {}