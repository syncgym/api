package com.syncgym.api.security.controllers;

import com.syncgym.api.security.entities.AccountCredentials;
import com.syncgym.api.shared.exceptions.SyncgymException;
import org.springframework.http.ResponseEntity;

public interface AuthController {


    ResponseEntity<?> signIn(AccountCredentials data) throws SyncgymException;

    ResponseEntity<?> signUp(AccountCredentials data) throws SyncgymException;

    ResponseEntity<?> refreshToken(String username, String refreshToken) throws SyncgymException;
}
