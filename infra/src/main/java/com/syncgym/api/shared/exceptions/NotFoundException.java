package com.syncgym.api.shared.exceptions;

import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.io.Serial;

public class NotFoundException extends SyncgymException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(final String message) {
        super(new SyncgymResponse<>(CommonConstants.NOT_FOUND, CommonConstants.NOT_FOUND_STATUS, message));
    }
}
