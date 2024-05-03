package com.example.validation.validate;

import com.example.validation.annotation.DateValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.AssertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// custom annotation 검증 클래스
public class DateValidValidator implements ConstraintValidator<DateValid,String> {

    private String pattern;

    @Override
    public void initialize(DateValid constraintAnnotation) {
        pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // LocalDate.parse : 잘못된 날짜 형식이 들어오면 throws 던짐 -> try-catch
        try{
            var localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
