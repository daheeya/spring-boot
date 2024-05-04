package com.example.exception.advice;

import com.example.exception.errors.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PageControllerAdvice {
    /*
    @ExceptionHandler(value = MyException.class)
    public String pageControllerAdvice(MyException myException){  // 리턴타입 String
        return "/error/404";
    }
    */

    //@ExceptionHandler(value = MyException.class)
    public String pageControllerAdvice(MyException myException){  // 리턴타입 String
        return "redirect:/page/user/redirect";  //
    }

}
