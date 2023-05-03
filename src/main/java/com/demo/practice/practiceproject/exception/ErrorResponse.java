package com.demo.practice.practiceproject.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    public LocalDateTime timestamp;
    public int code;
    public String statusMessage;
    public String errorMessage;

    public ErrorResponse(HttpStatus status, String errorMessage) {
        this.timestamp = LocalDateTime.now();
        this.code = status.value();
        this.statusMessage = status.getReasonPhrase();
        this.errorMessage = errorMessage;
    }
}
