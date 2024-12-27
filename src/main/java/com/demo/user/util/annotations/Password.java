package com.demo.user.util.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

  String message() default "Contraseña no valida, debe cumplir con el patron indicado.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
