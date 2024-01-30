package com.syncgym.api.shared.responses;

import java.io.Serial;
import java.io.Serializable;

public class SyncgymResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String status;

    private final int code;

    private final String message;

    private final T data;

    public SyncgymResponse(String status, int code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public SyncgymResponse(String status, int code, String message) {
        this(status, code, message, null);
    }


    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
