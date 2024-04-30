package com.example.aop.controller;

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
    @PostMapping("/user")
    public ResponseEntity<UserInfoDto> userInfo(@RequestBody UserInfoDto userInfoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoDto);
    }
}
