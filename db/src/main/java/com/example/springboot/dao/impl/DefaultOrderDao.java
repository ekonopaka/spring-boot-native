package com.example.springboot.dao.impl;

import com.example.springboot.dao.OrderDao;
import com.example.springboot.model.Order;
import com.example.springboot.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class DefaultOrderDao implements OrderDao {

    private static final List<Order> STORAGE = List.of(
            new Order(1L, 1L, List.of(
                    new OrderItem(1L, "Apple", new BigDecimal("1.01")))),
            new Order(2L, 1L, List.of(
                    new OrderItem(2L, "Banana", new BigDecimal("2.01")),
                    new OrderItem(3L, "Meat", new BigDecimal("2.05"))))
    );

    @Override
    public Order getOrder(long orderId) {
        return STORAGE.stream()
                      .filter(order -> order.id().equals(orderId))
                      .findFirst()
                      .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @Override
    public Optional<Order> findOrder(long orderId) {
        return STORAGE.stream()
                      .filter(order -> order.id().equals(orderId))
                      .findFirst();
    }

    @Override
    public List<Order> listOrders(long userId) {
        return STORAGE.stream()
                      .filter(order -> order.userId().equals(userId))
                      .toList();
    }
}