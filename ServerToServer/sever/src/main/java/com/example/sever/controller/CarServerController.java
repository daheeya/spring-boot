package com.example.sever.controller;

import com.example.sever.dto.CarServerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/server")
public class CarServerController {

    @GetMapping(path = "/get")
    public CarServerDto getCar(@RequestParam(name = "name")String name,
                       @RequestParam(name = "age")Integer age) {

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        CarServerDto carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        return carServerDto;
    }

    @GetMapping(path = "/user/{id}/pw/{pw}")
    public ResponseEntity<CarServerDto> getUser(@RequestParam(name = "name")String name,
                                @RequestParam(name = "age")Integer age,
                                @PathVariable(name = "id")String id,
                                @PathVariable(name = "pw")String pw) {

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        CarServerDto carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-auth",id+":"+pw);
        httpHeaders.add("time", LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(carServerDto);
    }
}
