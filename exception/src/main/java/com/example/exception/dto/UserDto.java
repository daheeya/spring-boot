package com.example.exception.dto;

import jakarta.validation.constraints.*;

public class UserDto {
    @NotEmpty
    @Size(min = 1,max = 10)
    private String name;
    @NotNull  // Integer 은 NotNull
    @Min(value = 1)  // 최소값만 줄 땐 Min 어노테이션 사용
    private Integer age;  // Integer 사용

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
