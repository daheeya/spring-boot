package com.naver.hello.controller;

import com.naver.hello.dto.CarDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path="/apis")
@RestController
public class PutApiController {

    @PutMapping(path = "/put")
    public CarDto putObj (@RequestBody CarDto carDto){
        System.out.println(carDto);
        return carDto;
    }

    @PutMapping(path = "/put/{user}/{id}")
    public CarDto paramObj(@PathVariable(name = "user")String user,
                           @PathVariable(name = "id")int id,
                           @RequestBody CarDto carDto){
        carDto.setName(user);
        carDto.setAge(id);
        System.out.println(user+":"+id);
        return carDto;
    }
}
