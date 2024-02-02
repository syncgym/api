package com.syncgym.api.security.responses;

import com.syncgym.api.security.rest.Token;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class RefreshTokenResponse extends SyncgymResponse<Token> {

    public RefreshTokenResponse(String status, int code, String message, Token data) {
        super(status, code, message, data);
    }
}
