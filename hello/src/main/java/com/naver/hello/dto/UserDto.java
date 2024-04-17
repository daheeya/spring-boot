package com.naver.hello.dto;

public class UserDto {  // date를 전송하기 위한 객체 컨트롤러를 통해 보낸다.


    private String name;
    private int age;
    private String email;
    private int idx;
    private String nick;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    // ObjectWrapper 가 사용하기 때문에 getter setter 을 꼭 만들어주기 (jackson)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
