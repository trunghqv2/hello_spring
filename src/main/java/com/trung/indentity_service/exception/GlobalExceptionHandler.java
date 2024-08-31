package com.trung.indentity_service.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlingRuntimeException(RuntimeException e) {
       return ResponseEntity.badRequest().body(e.getMessage());
   }
   @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingValidationException(MethodArgumentNotValidException e) {
       return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
   }
}
