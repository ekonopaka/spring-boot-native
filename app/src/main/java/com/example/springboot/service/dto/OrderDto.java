package com.example.springboot.service.dto;

import com.example.springboot.model.Order;

import java.util.List;

public record OrderDto(Long id,
                       Long userId,
                       List<OrderItemDto> items) {
    public static OrderDto asDto(Order order) {
        return new OrderDto(order.id(),
                            order.userId(),
                            order.items()
                                 .stream()
                                 .map(OrderItemDto::asDto)
                                 .toList());
    }
}