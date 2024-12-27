package com.demo.user.util.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

public class PasswordValidator implements ConstraintValidator<Password, String> {

  @Value("${valid-formats.password-pattern}")
  private String passwordPattern;

  @Override
  public void initialize(Password constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }
    return value.matches(passwordPattern);
  }
}
