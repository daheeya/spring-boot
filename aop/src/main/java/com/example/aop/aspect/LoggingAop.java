package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

// LoggingAop (aop -> aspect -> LoggingAop)
@Aspect
public class LoggingAop {
    @Pointcut(value = "execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}

    @Before(value = "execution(* com.example.aop.controller.ApiController.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("app before");
        var buffers = new StringBuilder();
        buffers.append("class name: ")
                .append(joinPoint.getTarget().getClass().getSimpleName())
                .append(", method name")
                .append(joinPoint.getSignature().getName())
                .append("\n");

        Arrays.stream(joinPoint.getArgs()).forEach(a->{
            buffers.append("args type = ")
                    .append(a.getClass().getSimpleName()+",")
                    .append("args value = ")
                    .append(a)
                    .append("\n");
        });
    }
}
