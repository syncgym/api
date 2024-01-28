package com.syncgym.api.shared.responses;

import java.io.Serial;
import java.io.Serializable;

public record SyncgymResponse<T>(String status, int code, String message, T data) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public SyncgymResponse(String status, int code, String message) {
        this(status, code, message, null);
    }
}
