package com.example.day3lms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private Map<String, String> errors;
}

