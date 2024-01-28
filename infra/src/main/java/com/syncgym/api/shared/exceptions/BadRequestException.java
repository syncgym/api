package com.syncgym.api.shared.exceptions;

import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.io.Serial;

public class BadRequestException extends SyncgymException {

    @Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException(final String message) {
        super(new SyncgymResponse<>(CommonConstants.BAD_REQUEST, CommonConstants.BAD_REQUEST_STATUS, message));
    }
}
