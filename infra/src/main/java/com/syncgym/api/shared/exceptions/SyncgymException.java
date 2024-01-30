package com.syncgym.api.shared.exceptions;

import com.syncgym.api.shared.responses.SyncgymResponse;

import java.io.Serial;

public class SyncgymException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private final SyncgymResponse<?> response;

    public SyncgymException(SyncgymResponse<?> response) {
        super(response.getMessage());
        this.response = response;
    }

    public SyncgymResponse<?> getResponse() {
        return response;
    }
}
