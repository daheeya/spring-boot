package com.example.ioc.dto;

import com.example.ioc.component.encode.ApplicationContextProvider;
import com.example.ioc.component.encode.BaseEncoder;
import com.example.ioc.component.encode.Encoder;
import com.example.ioc.component.encode.IEncode;

import java.net.http.HttpClient;

public class MsgConverterDto {
    private String msg;
    public MsgConverterDto(){}
    public MsgConverterDto(Builder builder){
        this.msg=builder.msg;
    }

    public String getMsg(){
        // IEncode encode = ApplicationContextProvider.getContext().getBean(BaseEncoder.class);
        //IEncode encode = (BaseEncoder) ApplicationContextProvider.getContext().getBean("BaseEncoder");
        //URLEncoder bean 을 활용해서 msg를 리턴해보세요.
        /*Encoder encode = ApplicationContextProvider.getContext()
                .getBean(Encoder.class);*/
        //Encoder를 바꾸어보자.
        Encoder encode = ApplicationContextProvider.getContext()
                .getBean(Encoder.class);
        encode.setEncode(ApplicationContextProvider.getContext()
                .getBean(BaseEncoder.class));
        return encode.encodeStr(msg);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String msg;
        public Builder msg(String msg){
            this.msg=msg;
            return this;
        }
        public MsgConverterDto build(){
            return new MsgConverterDto(this);
        }
    }
}
