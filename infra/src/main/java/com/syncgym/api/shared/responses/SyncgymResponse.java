package com.syncgym.api.shared.responses;

import java.io.Serial;
import java.io.Serializable;

public class SyncgymResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String status;
    private int code;
    private String message;
    private T data;

    public SyncgymResponse(String status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public SyncgymResponse(String status, int code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
