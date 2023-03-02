package com.example.springboot.controllers;

import com.example.springboot.service.OrdersService;
import com.example.springboot.service.UserService;
import com.example.springboot.service.dao.OrderDto;
import com.example.springboot.service.dao.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerBaseController {

    private final OrdersService ordersService;
    private final UserService userService;

    @Autowired
    public CustomerBaseController(OrdersService ordersService, UserService userService) {
        this.ordersService = ordersService;
        this.userService = userService;
    }

    @RequestMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") long userId) {
        return UserDto.asDto(userService.getUser(userId));
    }

    @RequestMapping("/orders/user/{id}")
    public List<OrderDto> listOrders(@PathVariable("id") long userId) {
        return ordersService.listOrders(userId)
                            .stream()
                            .map(OrderDto::asDto)
                            .toList();
    }
}