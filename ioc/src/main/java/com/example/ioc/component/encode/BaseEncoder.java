package com.example.ioc.component.encode;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Base64;

// iEncoder 를 구현하고 있는 Component 들이 1개 이상이라면
// 우선순위 Component @Primary
@Primary
@Component
public class BaseEncoder implements IEncode{
    @Override
    public String encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
