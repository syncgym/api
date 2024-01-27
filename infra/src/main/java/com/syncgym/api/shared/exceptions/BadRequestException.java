package com.syncgym.api.shared.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class BadRequestException extends SyncgymException {

    @Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException(final String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
