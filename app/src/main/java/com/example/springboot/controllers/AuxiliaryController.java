package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuxiliaryController {

    @RequestMapping("/healthcheck")
    public String healthcheck() {
        return "I'm alive";
    }
}