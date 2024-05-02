package com.example.aop.controller;

import com.example.aop.annotation.MyEncode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.UserInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api")
@RestController
public class ApiController {
    // http://localhost:8081/api/user/max?name=david
    @GetMapping(path = "/user/{id}")
    public String userInfo(@PathVariable(name = "id") String userId,
                           @RequestParam(name = "name") String userName){
        return userId +":"+userName;
    }

    // http://localhost:8081/api/user
    @MyEncode
    @PostMapping("/user")
    public ResponseEntity<UserInfoDto> userInfo(@RequestBody UserInfoDto userInfoDto){
        System.out.println("controller:\n\n"+userInfoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoDto);
    }

    @Timer
    @DeleteMapping("/delete/user")
    public void deleteUser(@RequestParam(name = "id")String userId) throws InterruptedException {
        System.out.println("delete user ....");
        Thread.sleep(2000);
    }
}
