package com.syncgym.api.security.controllers;

import com.syncgym.api.security.rest.AccountCredentials;
import com.syncgym.api.security.rest.Token;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

public interface AuthController {

    ResponseEntity<SyncgymResponse<Token>> signIn(AccountCredentials data) throws SyncgymException;

    ResponseEntity<SyncgymResponse<Token>> signUp(AccountCredentials data) throws SyncgymException;

    ResponseEntity<SyncgymResponse<Token>> refreshToken(String username, String refreshToken) throws SyncgymException;
}
