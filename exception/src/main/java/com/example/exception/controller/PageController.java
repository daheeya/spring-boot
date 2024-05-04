package com.example.exception.controller;

import com.example.exception.errors.MyException;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/page")
@Controller  // html 페이지를 리턴한다.
@Validated // 가능
public class PageController {
    @GetMapping(path = "/get/user")
    public void user(@Size(min=2, max = 10)
                     @RequestParam(name = "name")String name,
            @NotNull
            @Min(1)
            @RequestParam(name = "age")Integer age){
        System.out.println("page controller user in...");
    }
    @GetMapping(path = "/error")
    public void error() throws MyException{
        throw new MyException();
    }
    @GetMapping(path = "/user/caller")
    public void userCaller() throws MyException{
        System.out.println("user caller");
        throw new MyException();
    }
    @GetMapping(path = "/user/redirect")
    public String userRedirect(){
        return "/user/login";
    }
}
