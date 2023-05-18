package com.demo.practice.practiceproject.exception;

public class UniqueFieldExistsException extends RuntimeException{
    public UniqueFieldExistsException(String message) {
        super(message);
    }
}
