package com.challenge.crud_example.infrastructure.handler;

import com.challenge.crud_example.infrastructure.controller.response.ErrorResponse;
import com.challenge.crud_example.infrastructure.exception.ResourceAlreadyExistsException;
import com.challenge.crud_example.infrastructure.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<Object> handleResourceNotFoundException
           (ResourceNotFoundException ex, WebRequest request) {
       ErrorResponse errorResponse = new ErrorResponse(
               LocalDateTime.now(),
               ex.getMessage(),
               HttpStatus.NOT_FOUND
       );


       return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(ResourceAlreadyExistsException.class)
   public ResponseEntity<Object> handleResourceAlreadyExistsException
           (ResourceAlreadyExistsException ex, WebRequest request) {
       ErrorResponse errorResponse = new ErrorResponse(
               LocalDateTime.now(),
               ex.getMessage(),
               HttpStatus.CONFLICT
       );
       return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
   }


   @ExceptionHandler(value = {RuntimeException.class})
   public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
       ErrorResponse errorResponse = new ErrorResponse(
               LocalDateTime.now(),
               ex.getMessage(),
               HttpStatus.INTERNAL_SERVER_ERROR
       );
       return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
   }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                String.join("", errors.values()),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}