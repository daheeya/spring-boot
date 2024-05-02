package com.example.aop.aspect;

import com.example.aop.component.Base64Coder;
import com.example.aop.component.IEcoder;
import com.example.aop.dto.UserInfoDto;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Base64;

@Aspect
public class EncodingAop {
    private final IEcoder base64Coder;
    public EncodingAop(IEcoder base64Coder){
        this.base64Coder=base64Coder;
    }
    @Pointcut("@annotation(com.example.aop.annotation.MyEncode)")
    private void enableDecode(){

    }
    @Before(value = "enableDecode()")
    public void before(JoinPoint joinPoint) throws Throwable {
        Arrays.stream(joinPoint.getArgs()).forEach(o->{
            if(o instanceof UserInfoDto){
                UserInfoDto dto=(UserInfoDto) o;
                dto.setEmail(base64Coder.encode(dto.getEmail()));
            }
        });
    }
    @AfterReturning(value = "enableDecode()", returning = "objReturn")
    public void afterReturn(JoinPoint joinPoint, Object objReturn){  // objReturn 받아온 객체로 철자 틀리면 안됨
        if(objReturn instanceof ResponseEntity){
            UserInfoDto dto = (UserInfoDto) ((ResponseEntity)objReturn).getBody();
            dto.setEmail(base64Coder.decode(dto.getEmail()));
        }
    }

}
