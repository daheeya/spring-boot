package com.example.validation.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorDto {
    private String response;
    private List<AgeError> errors=new ArrayList<>();

    public ErrorDto(){}
    public ErrorDto(Builder builder){
        this.response=builder.response;
        this.errors=builder.errors;
    }
    public static class AgeError{
        private String field;
        private String msg;
        public AgeError(){}
        public AgeError(Builder builder){
            this.field=builder.field;
            this.msg=builder.msg;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public static Builder builder(){
            return new ErrorDto.AgeError.Builder();
        }
        public static class Builder{
            private String field;
            private String msg;


            public Builder field(String field){
                this.field=field;
                return this;
            }
            public Builder msg(String msg){
                this.msg=msg;
                return this;
            }
            public AgeError build(){
                return new AgeError(this);
            }
        }
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<AgeError> getErrors() {
        return errors;
    }

    public void setErrors(List<AgeError> errors) {
        this.errors=errors;
    }

    // 빌드 후에 손대기 힘들어서 추가.
    public void addErorr(AgeError ageError){
        errors.add(ageError);
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "response='" + response + '\'' +
                ", errors=" + errors +
                '}';
    }

    public static Builder builder(){
        return new ErrorDto.Builder();
    }
    public static class Builder{
        private String response;
        private List<AgeError> errors=new ArrayList<>();
        public Builder response(String response){
            this.response=response;
            return this;
        }
        // 의미가 없어졌다. 그냥 addErrors 메서드를  추가함.
        public Builder errors(List<AgeError> errors){
            this.errors=errors;
            return this;
        }
        public Builder errors(AgeError ageError){
            this.errors.add(ageError);
            return this;
        }
        public ErrorDto build(){
            return new ErrorDto(this);
        }
    }
}
