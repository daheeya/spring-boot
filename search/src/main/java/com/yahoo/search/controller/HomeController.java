package com.yahoo.search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping(path = "")
    public String home(){
        return "/home";
    }
}
