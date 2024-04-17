package com.naver.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HobbyDto {
    // 아래의 Json을 Dto class로 만드시오!
    /*{
        "name":"888-9999",
            "email":"david@gamil.com",
            "my_hobby":{
        "name":"kick",
                "use":"football",
                "terms":29
    }
    }*/
    @JsonProperty(required = true)  // required = true : 매핑할 때 무조건 필요한 속성으로 지정
    private String name;
    private String email;
    @JsonProperty(value = "my_hobby",required = true)  //my_hobby로 매핑해준다.
    private My_hobby myHobby;  // 변수명이. Json은 snake case . 자바는 camel case..

    private static class My_hobby{  // static 필수 !
        private String name;
        private String use;
        private int terms;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUse() {
            return use;
        }

        public void setUse(String use) {
            this.use = use;
        }

        public int getTerms() {
            return terms;
        }

        public void setTerms(int terms) {
            this.terms = terms;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public My_hobby getMyHobby() {
        return myHobby;
    }

    public void setMyHobby(My_hobby myHobby) {
        this.myHobby = myHobby;
    }
}
