package com.example.thymeleaf_.component;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public String hello(String data) {
        return "Hello "+data;
    }
}
