package com.syncgym.api.shared.exceptions.handler;

import java.io.Serial;
import java.io.Serializable;

public record ExceptionResponse(String message, String details, int code) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
