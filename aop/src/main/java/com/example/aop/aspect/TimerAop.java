package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class TimerAop {
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer() {
    }

    @Around(value = "enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        // before
        StopWatch sw = new StopWatch();
        sw.start();
        joinPoint.proceed();  // 프로시ㅗ로 수면 측정 불푤요
        // after
        sw.stop();
        System.out.println("total time:" + sw.getTotalTimeSeconds());
    }


}
