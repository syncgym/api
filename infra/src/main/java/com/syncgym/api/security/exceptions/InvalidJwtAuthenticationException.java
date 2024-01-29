package com.syncgym.api.security.exceptions;

import com.syncgym.api.shared.exceptions.ForbiddenException;

import java.io.Serial;

public class InvalidJwtAuthenticationException extends ForbiddenException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}
