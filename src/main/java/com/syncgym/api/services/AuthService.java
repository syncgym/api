package com.syncgym.api.services;

import com.syncgym.api.data.dto.v1.security.AccountCredentialsDTOV1;
import com.syncgym.api.data.dto.v1.security.TokenDTOV1;
import com.syncgym.api.repositories.UserRepository;
import com.syncgym.api.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    public ResponseEntity<TokenDTOV1> signIn(AccountCredentialsDTOV1 data) {
        try {
            var username = data.getUsername();
            var password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            var user = repository.findByUsername(username);

            var tokenResponse = new TokenDTOV1();

            if (user == null) throw new UsernameNotFoundException("Username " + username + " not found");

            tokenResponse = tokenProvider.createAccessToken(username, user.getRoles());

            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    public ResponseEntity<TokenDTOV1> refreshToken(String username, String refreshToken) {
        var user = repository.findByUsername(username);

        var tokenResponse = new TokenDTOV1();

        if (user == null) throw new UsernameNotFoundException("Username " + username + " not found");

        tokenResponse = tokenProvider.refreshToken(refreshToken);

        return ResponseEntity.ok(tokenResponse);
    }
}
