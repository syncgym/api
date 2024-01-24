package com.syncgym.api.controllers;

import com.syncgym.api.data.dto.v1.security.AccountCredentialsDTOV1;
import com.syncgym.api.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/signin")
    public ResponseEntity<?> signIn(@RequestBody AccountCredentialsDTOV1 data) {
        if (checkIfParamsNotNull(data))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        var token = authService.signIn(data);

        if (token == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        return token;
    }

    @PutMapping(value = "/refresh/{username}")
    public ResponseEntity<?> refreshToken(
            @PathVariable("username") String username,
            @RequestHeader("Authorization") String refreshToken
    ) {
        if (checkIfParamsNotNull(username, refreshToken))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        var token = authService.refreshToken(username, refreshToken);

        if (token == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        return token;
    }

    private static boolean checkIfParamsNotNull(String username, String refreshToken) {
        return refreshToken == null || refreshToken.isBlank() || username == null || username.isBlank();
    }

    private boolean checkIfParamsNotNull(AccountCredentialsDTOV1 data) {
        return data == null || data.getUsername() == null || data.getUsername().isBlank()
                || data.getPassword() == null || data.getPassword().isBlank();
    }
}
