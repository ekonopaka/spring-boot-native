package com.example.springboot.model;

import java.math.BigDecimal;

public record OrderItem(Long id,
                        String name,
                        BigDecimal price) {
}