package com.syncgym.api.shared.exceptions;

import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.io.Serial;

public class ForbiddenException extends SyncgymException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ForbiddenException(final String message) {
        super(new SyncgymResponse<>(CommonConstants.FORBIDDEN, CommonConstants.FORBIDDEN_STATUS, message));
    }
}
