package com.syncgym.api.security.exceptions;

import com.syncgym.api.shared.exceptions.InternalErrorException;

import java.io.Serial;

public class PermissionNotFoundException extends InternalErrorException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PermissionNotFoundException(String message) {
        super(message);
    }
}
