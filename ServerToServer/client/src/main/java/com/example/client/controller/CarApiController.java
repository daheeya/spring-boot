package com.example.client.controller;

import com.example.client.dto.CarDto2;
import com.example.client.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RequestMapping("/api/client")
@RestController
@RequiredArgsConstructor
public class CarApiController {

    private final CarService carService;
    @GetMapping(path = "")
    public CarDto2 getCar(@RequestParam(name = "name")String name,
                          @RequestParam(name = "age")int age){
        return carService.getForObject(name,age);
    }

    @GetMapping(path = "/entity")
    public CarDto2 getUser(@RequestParam(name = "name")String name,
                          @RequestParam(name = "age")int age){
        return carService.getForEntity(name,age);
    }


}