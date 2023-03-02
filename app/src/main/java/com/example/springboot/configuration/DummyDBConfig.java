package com.example.springboot.configuration;

import com.example.springboot.dao.OrderDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.dao.impl.DefaultOrderDao;
import com.example.springboot.dao.impl.DefaultUserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyDBConfig {

    @Bean
    public UserDao userDao() {
        return new DefaultUserDao();
    }

    @Bean
    public OrderDao orderDao() {
        return new DefaultOrderDao();
    }
}