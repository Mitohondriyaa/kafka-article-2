package io.mitochondria.inventory.event;

public record InventoryRejectedEvent(String orderID, String email) {}