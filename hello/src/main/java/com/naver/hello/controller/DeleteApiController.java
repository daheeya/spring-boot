package com.naver.hello.controller;


import org.springframework.web.bind.annotation.*;

@RequestMapping(path ="/apis")
@RestController
public class DeleteApiController {
    @DeleteMapping(path="/delete/user/{id}")
    public void deleteObj(@PathVariable(name = "id")int id){
        System.out.println("delete user id : "+ id);

    }
}
