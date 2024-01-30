package com.syncgym.api.security.services.signInService;

import com.syncgym.api.security.entities.AccountCredentials;
import com.syncgym.api.security.entities.Token;
import com.syncgym.api.shared.exceptions.SyncgymException;

public interface SignInService {

    Token execute(AccountCredentials data) throws SyncgymException;
}
