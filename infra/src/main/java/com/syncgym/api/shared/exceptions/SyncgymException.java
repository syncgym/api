package com.syncgym.api.shared.exceptions;

import java.io.Serial;

public class SyncgymException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int code;

    public SyncgymException(final int code, final String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
