package com.example.springboot.service.dto;

import com.example.springboot.model.OrderItem;

import java.math.BigDecimal;

public record OrderItemDto(Long id,
                           String name,
                           BigDecimal price) {
    public static OrderItemDto asDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.id(), orderItem.name(), orderItem.price());
    }
}