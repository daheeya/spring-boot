package com.example.client.service;

import com.example.client.dto.CarDto2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@Slf4j
@Service
public class CarService {

    private final RestTemplate template;

    // GET Http://localhost:9090/api/server/get?name=kim&age=19
    public CarDto2 getForObject(String name, int age){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/get").
                queryParam("name",name).
                queryParam("age",age).
                encode().  // url 인코딩
                build().toUri();
        log.info("uri str={}", uri);

        var carDto=template.getForObject(uri, CarDto2.class);
        log.info("server to client return obj = {}", carDto);

        return null;
    }

    // GET Http://localhost:9090/api/server/user/{id}/pw/{pw}?name=kim&age=19
    public CarDto2 getForEntity(String name, int age){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/user/{id}/pw/{pw}").
                queryParam("name",name).
                queryParam("age",age).
                encode().  // url 인코딩
                        // pathvariable은 expand()를 활용해서 중괄호 순서대로 명기하면 된다.
                build().expand("coolmax","1234").toUri();
        log.info("uri str={}", uri);

        var resDto = template.getForEntity(uri, CarDto2.class);

        log.info("server http status={}", resDto.getStatusCode().toString());
        log.info("server header\n info1={}\n info2={}", resDto.getHeaders().get("x-auth"),resDto.getHeaders().get("time"));
        log.info("server body={}",resDto);

        return resDto.getBody();
    }
}
