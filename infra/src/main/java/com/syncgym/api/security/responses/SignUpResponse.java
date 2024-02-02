package com.syncgym.api.security.responses;

import com.syncgym.api.security.rest.Token;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class SignUpResponse extends SyncgymResponse<Token> {

    public SignUpResponse(String status, int code, String message, Token data) {
        super(status, code, message, data);
    }
}
