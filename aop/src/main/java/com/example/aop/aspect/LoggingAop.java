package com.example.aop.aspect;

import com.example.aop.dto.UserInfoDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

// LoggingAop (aop -> aspect -> LoggingAop)
@Aspect
public class LoggingAop {
    /*
    //@Pointcut(value = "execution(* com.example.aop.controller..*.*(..))")   // 컨트롤러 안에 있는 모든 페키지, 모든 클래스, 모든 메소드
    //private void cut(){}

    @Pointcut(value = "execution(String com.example.aop.controller..*.*(..))") // String 리턴
    private void cut(){}

    //    @Pointcut(value = "execution(ResponseEntity com.example.aop.controller..*.*(..))") //ResponseEntity 리턴 -> ResponseEntity를 못찾아서 오류가뜬다.
    @Pointcut(value = "execution(org.springframework.http.ResponseEntity com.example.aop.controller..*.*(..))") //ResponseEntity 리턴 자바 기본패키지가 아니라서 풀 패키지명을 적어준다.
    private void cut1(){}

    @Pointcut(value = "execution(* com.example.aop.controller..*.*(..)) && args(id, name)")
    private void cut3(String id, String name){}

    //post 테스트
    @Pointcut(value = "execution(* com.example.aop.controller..*.*(..)) && args(userInfoDto)")
    private void cut4(UserInfoDto userInfoDto){}

    @Before(value = "cut4(userInfoDto)")
    public void before(JoinPoint joinPoint,UserInfoDto userInfoDto) { // JoinPoint 외에 id 와 name 추가
        userInfoDto.setEmail(Base64.getEncoder().encodeToString(userInfoDto.getEmail().getBytes()));
        System.out.println(userInfoDto);
    }

    // value의 포이인크 멋 풀경로 오경햇따.ㅇ
    @AfterReturning(value = "cut4(com.example.aop.dto.UserInfoDto)", returning = "returnObj") // 컨트롤러를 거쳐서 리턴 된 것을 받아올 수 있다. , returning 인자는 필수
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        if(returnObj instanceof ResponseEntity) {  // RsponseEntity 인 이유!
            String status = ((ResponseEntity) returnObj).getStatusCode().toString();
            var dto = (UserInfoDto) ((ResponseEntity) returnObj).getBody();
            dto.setEmail(Base64.getEncoder().encodeToString(dto.getEmail().getBytes()));
        }
    }

    /*
    @Before(value = "cut3(id,name)")
    public void before(JoinPoint joinPoint, String id, String name){ // JoinPoint 외에 id 와 name 추가
        System.out.println(id+":"+name);


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
     */

    /*
    @Before(value = "cut()")
    //@Before(value = "execution(* com.example.aop.controller.ApiController.*(..))")
    public void before(JoinPoint joinPoint){ // join 하는 시점에 사용자의 요청을 알 수 있다.
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
        });*/

}
