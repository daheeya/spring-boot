package com.example.exception.controller;

import com.example.exception.dto.UserDto;
import com.example.exception.errors.MyException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated // param이나 메소드에 검증할 수 있다., spring validation 모듈
@RestController()
@RequestMapping(path = "/apis" )
public class UserController {

    @GetMapping(path = "/get/user")
    public ResponseEntity getUser(
            @Size(min=5)
            @RequestParam(name = "name")String name,
                                  @NotNull
                                  @Min(value = 1)
                                  @RequestParam(name = "age")Integer age){
        var dto = new UserDto();
        dto.setName(name);
        dto.setAge(age);
        return ResponseEntity.ok(dto);
    }
    @PostMapping(path = "/post/user")
    public UserDto postUser(@Valid @RequestBody UserDto userDto){
        return userDto;
    }
    @GetMapping(path = "/error")
    public void customException() throws Exception{
        System.out.println("custom exception");
        throw new Exception("허가되지 않은 사용자입니다.");
    }

    /*
    @ExceptionHandler(value = Exception.class)  // 모든 익셉션은 익셉션 클래슬르 상속받는다.
    public ResponseEntity handlerException(Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
    */


    // myException 적용
    //@ExceptionHandler(value = {MyException.class, Exception.class})  // {} 로 배열 적용도 가능하다.
    public ResponseEntity handlerException(Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

}
