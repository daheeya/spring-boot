package com.example.ioc.component.encode;

import org.springframework.stereotype.Component;

// Encoder class에 interface 를 주입받도록 넣어보자.
@Component
public class Encoder {
    /*
    private final BaseEncoder webEncoder;

    // 생성자 주입방식
    public Encoder(BaseEncoder webEncoder){
        this.webEncoder=webEncoder;
    }
    public String encodeStr(String msg){
        return webEncoder.encode(msg);
    }*/

    private IEncode iEncode;
    // 생성자 주입 방식
    // 인터페이스이기 때문에 구현체 컴포넌트를 넣는다.
    public Encoder(IEncode iEncode){
        this.iEncode=iEncode;
    }
    public String encodeStr(String msg){
        return iEncode.encode(msg);
    }
    public void setEncode(IEncode iEncode){
        this.iEncode=iEncode;
    }

}
