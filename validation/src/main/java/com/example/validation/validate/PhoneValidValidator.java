package com.example.validation.validate;

import com.example.validation.annotation.TelValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneValidValidator implements ConstraintValidator<TelValid, String> {
    private String pattern;

    @Override
    public void initialize(TelValid constraintAnnotation) {
        pattern=constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String i, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Pattern.matches(pattern, i);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
