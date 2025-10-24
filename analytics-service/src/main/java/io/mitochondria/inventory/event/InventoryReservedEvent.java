package io.mitochondria.inventory.event;

public record InventoryReservedEvent(String orderID, String email) {}