package com.example.springboot.controllers;

import com.example.springboot.service.OrdersService;
import com.example.springboot.service.UserService;
import com.example.springboot.service.dto.OrderDto;
import com.example.springboot.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        Optional<UserDto> userDto = userService.findUser(userId).map(UserDto::asDto);

        if (userDto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        return userDto.get();
    }

    @RequestMapping("/orders/user/{id}")
    public List<OrderDto> listOrders(@PathVariable("id") long userId) {
        return ordersService.listOrders(userId)
                            .stream()
                            .map(OrderDto::asDto)
                            .toList();
    }
}