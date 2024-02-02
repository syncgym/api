package com.syncgym.api.security.services.refreshTokenService;

import com.syncgym.api.security.exceptions.InvalidJwtAuthenticationException;
import com.syncgym.api.security.jwt.JwtTokenProvider;
import com.syncgym.api.security.rest.Token;
import com.syncgym.api.shared.exceptions.SyncgymException;
import org.springframework.beans.factory.annotation.Autowired;

public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    public Token execute(String username, String refreshToken) throws SyncgymException {
        try {
            return tokenProvider.refreshToken(refreshToken, username);
        } catch (Exception e) {
            throw new InvalidJwtAuthenticationException("Invalid JWT token");
        }
    }
}
