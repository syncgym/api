package com.syncgym.api.security.services.signInService;

import com.syncgym.api.delivery.user.repositories.UserRepository;
import com.syncgym.api.security.entities.AccountCredentials;
import com.syncgym.api.security.entities.Token;
import com.syncgym.api.security.exceptions.ForbiddenCredentialsException;
import com.syncgym.api.security.exceptions.UserNotFoundException;
import com.syncgym.api.security.jwt.JwtTokenProvider;
import com.syncgym.api.shared.exceptions.SyncgymException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

public class SignInServiceImpl implements SignInService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository repository;

    @Override
    public Token execute(AccountCredentials data) throws SyncgymException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.username(), data.password()));

            var user = repository.findUserByUsername(data.username())
                    .orElseThrow(UserNotFoundException::new);

            return tokenProvider.createAccessToken(data.username(), user.getRoles());
        } catch (AuthenticationException e) {
            throw new ForbiddenCredentialsException();
        }
    }

}
