package com.example.ioc.component.config;

import com.example.ioc.dto.ReqDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// JsonConv class(=Bean)
public class JsonConv {
    private ObjectMapper objectMapper;
    public JsonConv(){
        this.objectMapper=new ObjectMapper();
    }
    public String objTojson(Object object) throws JsonProcessingException {
        if(object instanceof ReqDto){
            return objectMapper.writeValueAsString((ReqDto)object);
        }
        return "";
    }
}
