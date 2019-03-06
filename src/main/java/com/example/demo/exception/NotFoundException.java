package com.example.demo.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7860691238040502302L;

    public NotFoundException(final String message, final UUID id) {
        super(String.format(message + " Object id: %s", id));
    }
}