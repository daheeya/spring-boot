package com.naver.hello.objectwrapper;

public class User {
    private String name;
    private int age;

    public User(){}  // default constructor : Object wraaper 에서 필요하다.

    private User(Builder builder){  // 생성자. public일 필요가 없다. : Builder.builder 로 outer class 생성
        this.name=builder.name;
        this.age=builder.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // inner 클래스
    public static class Builder{  // static : User 을 생성하지 않아도. User.Builder 로 생성할 수 있따.
        private String name;
        private int age;  // 부모의 속성을 그대로 가진다.

        public Builder name (String name){
            this.name=name;
            return this;
        }

        public Builder age (int age){
            this.age=age;
            return this;
        }

        public User build(){  // outer class 생성
            return new User(this);
        }  // 본인을 반환해서 연쇄적인 get이 가능하다.
    }
}
