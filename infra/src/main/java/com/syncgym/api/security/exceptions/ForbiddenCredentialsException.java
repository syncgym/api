package com.syncgym.api.security.exceptions;

import com.syncgym.api.shared.exceptions.ForbiddenException;

import java.io.Serial;

public class ForbiddenCredentialsException extends ForbiddenException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ForbiddenCredentialsException() {
        super("Invalid username/password supplied");
    }
}
