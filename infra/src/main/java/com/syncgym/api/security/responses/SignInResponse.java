package com.syncgym.api.security.responses;

import com.syncgym.api.security.entities.Token;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class SignInResponse extends SyncgymResponse<Token> {

    public SignInResponse(String status, int code, String message, Token data) {
        super(status, code, message, data);
    }
}
