package com.example.springboot.dao;

import com.example.springboot.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    Order getOrder(long orderId);

    Optional<Order> findOrder(long orderId);

    List<Order> listOrders(long userId);
}