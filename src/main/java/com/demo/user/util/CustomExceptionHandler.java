package com.demo.user.util;

import com.demo.user.model.api.ErrorBody;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
    String errorMessage = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> "Field:"+error.getField() + " Error:" + error.getDefaultMessage())
        .collect(Collectors.joining(","));
    return new ResponseEntity<>(new ErrorBody(errorMessage), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {ConstraintViolationException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex) {
    String errorMessage = ex.getConstraintViolations().stream()
        .map(error -> "Field:"+error.getPropertyPath() + " Error:" + error.getMessage())
        .collect(Collectors.joining(","));
    return new ResponseEntity<>(new ErrorBody(errorMessage), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<?> internalServerError(Exception ex) {
    return new ResponseEntity<>(new ErrorBody(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
