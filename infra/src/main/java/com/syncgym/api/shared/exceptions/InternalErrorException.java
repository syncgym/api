package com.syncgym.api.shared.exceptions;

import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.io.Serial;

public class InternalErrorException extends SyncgymException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InternalErrorException(final String message) {
        super(new SyncgymResponse<>(CommonConstants.INTERNAL_SERVER_ERROR, CommonConstants.INTERNAL_SERVER_ERROR_STATUS, message));
    }
}
