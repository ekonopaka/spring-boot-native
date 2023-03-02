package com.example.springboot.model;

import java.util.List;

public record Order(Long id,
                    Long userId,
                    List<OrderItem> items) {
}