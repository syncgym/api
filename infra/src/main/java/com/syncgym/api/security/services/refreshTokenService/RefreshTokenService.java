package com.syncgym.api.security.services.refreshTokenService;

import com.syncgym.api.security.rest.Token;
import com.syncgym.api.shared.exceptions.SyncgymException;

public interface RefreshTokenService {

    Token execute(String username, String refreshToken) throws SyncgymException;
}
