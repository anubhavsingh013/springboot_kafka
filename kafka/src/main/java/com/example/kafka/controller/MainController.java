package com.example.kafka.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String hello(){
        return "hello kafka";
    }
    @GetMapping("/login")
    public String login(){
        return "login Success";
    }
}
