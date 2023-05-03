package com.demo.practice.practiceproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
