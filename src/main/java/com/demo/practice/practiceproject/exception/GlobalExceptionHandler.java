package com.demo.practice.practiceproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidFieldNameException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFieldNameException(InvalidFieldNameException e) {
        var status = HttpStatus.BAD_REQUEST;
        var errorResponse = new ErrorResponse(status, e.getMessage());
        return ResponseEntity.status(status).body(errorResponse);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        var status = HttpStatus.NOT_FOUND;
        var errorResponse = new ErrorResponse(status, e.getMessage());
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(UniqueFieldExistsException.class)
    public ResponseEntity<ErrorResponse> handleUniqueFieldExistsException(UniqueFieldExistsException e) {
        var status = HttpStatus.BAD_REQUEST;
        var errorResponse = new ErrorResponse(status, e.getMessage());
        return ResponseEntity.status(status).body(errorResponse);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder message = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            message.append(fieldError.getDefaultMessage()).append(", ");
        }
        message.delete(message.length() - 2, message.length());
        String finalMessage;
        if (fieldErrors.size() > 1) {
            finalMessage = "Multiple invalid fields: " + message;
        } else {
            finalMessage = "Invalid field: " + message;
        }
        var status = HttpStatus.BAD_REQUEST;
        var errorResponse = new ErrorResponse(status, finalMessage);
        return ResponseEntity.status(status).body(errorResponse);
    }
}
