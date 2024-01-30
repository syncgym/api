package com.syncgym.api.security.controllers;

import com.syncgym.api.security.entities.AccountCredentials;
import com.syncgym.api.security.services.refreshTokenService.RefreshTokenService;
import com.syncgym.api.security.services.signInService.SignInService;
import com.syncgym.api.security.services.signUpService.SignUpService;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@Tag(name = "Auth", description = "Endpoint for Auth")
public class AuthControllerImpl implements AuthController {

    private final SignInService signInService;

    private final SignUpService signUpService;

    private final RefreshTokenService refreshTokenService;

    public AuthControllerImpl(SignInService signInService, SignUpService signUpService, RefreshTokenService refreshTokenService) {
        this.signInService = signInService;
        this.signUpService = signUpService;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    @PostMapping(path = "/signIn")
    public ResponseEntity<?> signIn(@Valid @RequestBody AccountCredentials data) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                signInService.execute(data)
        );

        return ResponseEntity.ok(res);
    }

    @Override
    @PostMapping(path = "/signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody AccountCredentials data) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                signUpService.execute(data)
        );

        return ResponseEntity.ok(res);
    }

    @Override
    @PutMapping(path = "/refreshToken/{username}")
    public ResponseEntity<?> refreshToken(
            @PathVariable("username") String username, @RequestHeader("Authorization") String refreshToken
    ) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                refreshTokenService.execute(username, refreshToken)
        );

        return ResponseEntity.ok(res);
    }
}
