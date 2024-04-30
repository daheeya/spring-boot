package com.example.ioc.component.config;

import com.example.ioc.component.encode.BaseEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /*
    @Bean
    public BaseEncoder baseEncoder(){
        return new BaseEncoder();
    }*/
    @Bean
    public JsonConv jsonConv(){
        return new JsonConv();
    }
}
