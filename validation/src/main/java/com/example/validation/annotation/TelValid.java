
package com.example.validation.annotation;

import com.example.validation.validate.PhoneValidValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneValidValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelValid {
    String message() default "000-0000-0000 형태여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    //
    String pattern() default "\\d{3}-\\d{4}-\\d{4}";
}
