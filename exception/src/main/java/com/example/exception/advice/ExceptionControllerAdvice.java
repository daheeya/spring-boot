package com.example.exception.advice;

import com.example.exception.errors.MyException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = java.lang.Exception.class)
    public ResponseEntity exception(java.lang.Exception e){  // 리턴타입 json
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());  // 500번대 에러
    }

    @ExceptionHandler(value = ConstraintViolationException.class)  // 흔히 걸리는 익셉션 이 익셉션을 상속받는 익셉션들은 글로벌하게 이 핸들러로 빠진다.
    public ResponseEntity constraintViolationException(ConstraintViolationException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());  // 400 번대 에러
    }

    @ExceptionHandler(value = MyException.class)
    public ResponseEntity myException(java.lang.Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
