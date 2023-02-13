package com.example.javaservernetflix2023.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;


    public UserNotFoundException(String message) {
        super(message);
    }
}
