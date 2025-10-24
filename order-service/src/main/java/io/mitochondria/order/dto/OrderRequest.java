package io.mitochondria.order.dto;

public record OrderRequest(String email, String productName, Integer quantity) {}