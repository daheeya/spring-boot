package com.example.aop.component;

import java.util.Base64;

public class Base64Coder implements IEcoder{
    @Override
    public String encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }

    @Override
    public String decode(String msg) {
        return new String(Base64.getDecoder().decode(msg));
    }
}
