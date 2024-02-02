package com.syncgym.api.security.controllers;

import com.syncgym.api.security.responses.RefreshTokenResponse;
import com.syncgym.api.security.responses.SignInResponse;
import com.syncgym.api.security.responses.SignUpResponse;
import com.syncgym.api.security.rest.AccountCredentials;
import com.syncgym.api.security.rest.Token;
import com.syncgym.api.security.services.refreshTokenService.RefreshTokenService;
import com.syncgym.api.security.services.signInService.SignInService;
import com.syncgym.api.security.services.signUpService.SignUpService;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@Tag(name = "Auth", description = "Endpoint for Auth")
public class AuthControllerImpl implements AuthController {

    @Autowired
    private SignInService signInService;

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Override
    @Operation(summary = "SignIn", description = "All users can sign in to the system using this endpoint",
            tags = {"Auth"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = SignInResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    @PostMapping(path = "/signIn")
    public ResponseEntity<SyncgymResponse<Token>> signIn(@Valid @RequestBody AccountCredentials data) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                signInService.execute(data)
        );

        return ResponseEntity.ok(res);
    }

    @Override
    @Operation(summary = "SignUp", description = "Only admin can sign up a user",
            tags = {"Auth"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = SignUpResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    @PostMapping(path = "/signUp")
    public ResponseEntity<SyncgymResponse<Token>> signUp(@Valid @RequestBody AccountCredentials data) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                signUpService.execute(data)
        );

        return ResponseEntity.ok(res);
    }

    @Override
    @Operation(summary = "Refresh Token", description = "Refresh token for all users",
            tags = {"Auth"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = RefreshTokenResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    @PutMapping(path = "/refreshToken/{username}")
    public ResponseEntity<SyncgymResponse<Token>> refreshToken(
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
