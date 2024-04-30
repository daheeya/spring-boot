package com.example.ioc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResDto {
    // response:ok
    private String response;
    // json_msg: request에서 전송된 데이터의 json string
    @JsonProperty(value = "json_msg",required = true)
    private String jsonMsg;

    public ResDto(){}
    public ResDto(Builder builder){
        this.response= builder.response;
        this.jsonMsg=builder.jsonMsg;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getJsonMsg() {
        return jsonMsg;
    }

    public void setJsonMsg(String jsonMsg) {
        this.jsonMsg = jsonMsg;
    }

    public static class Builder{
        private String response;
        private String jsonMsg;
        public Builder response(String response){
            this.response=response;
            return this;
        }
        public Builder jsonMsg(String jsonMsg){
            this.jsonMsg=jsonMsg;
            return this;
        }
        public ResDto build(){
            return new ResDto(this);
        }
    }
    public static Builder builder(){
        return new Builder();
    }


}
