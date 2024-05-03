package com.example.validation.dto;

import com.example.validation.annotation.DateValid;
import com.example.validation.annotation.TelValid;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class RestDto {
    @NotBlank
    private String name;
    @Max(value = 110)
    @Min(value = 20)
    private int age;


    @Email
    private String email;
    @DateValid  // custom annotation 추가
    @Size(min = 10, max = 10)
    @JsonProperty(value = "req_year_month_day")
    private String reqYearMonthDay;

    @TelValid
    @Size(min = 13, max = 13)
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    /*
    // is+변수명+validation()
    @AssertTrue(message = "yyyy/MM/dd 형식이 아닙니다.")
    public boolean isReqYearMonthDayValidation(){  // 무조건 리턴타입 boolean
        String regex = "\\d{4}/\\d{2}/\\d{2}";  // yyyy/MM/dd 패턴
        // 받았는 코드와 정규식이 맞는지 매치
        return Pattern.matches(regex, this.reqYearMonthDay); // java.util.regex 의 Pattern 사용
    }
     */

    /*
    // 자바 로컬 타임 파싱
    @AssertTrue(message = "yyyy/MM/dd 형식이 아닙니다.")
    public boolean isReqYearMonthDayValidation() {
        // LocalDate.parse : 잘못된 날짜 형식이 들어오면 throws 던짐 -> try-catch
        try{
            var localDate = LocalDate.parse(this.reqYearMonthDay, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }catch (Exception e) {
            return false;
        }
        return true;
    }
     */

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

    public String getReqYearMonthDay() {
        return reqYearMonthDay;
    }

    public void setReqYearMonthDay(String reqYearMonthDay) {
        this.reqYearMonthDay = reqYearMonthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
