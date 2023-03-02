package com.example.springboot.service;

import com.example.springboot.dao.OrderDao;
import com.example.springboot.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrderDao orderDao;

    @Autowired
    public OrdersService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> listOrders(long userId) {
        return orderDao.listOrders(userId);
    }
}