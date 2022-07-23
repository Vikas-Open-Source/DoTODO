package com.dotodo.DoToDo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<Object> handleResponseStatusException(
      ResponseStatusException ex, WebRequest request) {
    Map<String, Object> exceptionData = new LinkedHashMap<>();
    exceptionData.put("status", ex.getRawStatusCode());
    exceptionData.put("message", ex.getReason());
    return new ResponseEntity<>(exceptionData, HttpStatus.BAD_REQUEST);
  }

  @Override
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException methodArgumentNotValidException,
      HttpHeaders headers,
      HttpStatus httpStatus,
      WebRequest webRequest) {
    final FieldError fieldError =
        methodArgumentNotValidException.getBindingResult().getFieldError();
    String errorMessage = fieldError == null ? "" : fieldError.getDefaultMessage();
    Map<String, Object> exceptionData = new LinkedHashMap<>();
    exceptionData.put("status", 400);
    exceptionData.put("message", errorMessage);
    return new ResponseEntity<>(exceptionData, HttpStatus.BAD_REQUEST);
  }
}
