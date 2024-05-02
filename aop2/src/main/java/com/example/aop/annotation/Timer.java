package com.example.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 메모리 할당 방식
@Retention(RetentionPolicy.RUNTIME)
// type: class, interface, eum 선언부에 선언 가능
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Timer {
}
