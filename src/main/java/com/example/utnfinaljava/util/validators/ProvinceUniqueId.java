package com.example.utnfinaljava.util.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProvinceUniqueIdValidator.class)
public @interface ProvinceUniqueId {
    String message() default "El codígo de la provincia ingresada ya existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
