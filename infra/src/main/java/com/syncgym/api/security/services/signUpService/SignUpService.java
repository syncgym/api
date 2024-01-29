package com.syncgym.api.security.services.signUpService;

import com.syncgym.api.security.entities.AccountCredentials;
import com.syncgym.api.security.entities.Token;
import com.syncgym.api.shared.exceptions.SyncgymException;

public interface SignUpService {

    Token execute(AccountCredentials accountCredentials) throws SyncgymException;
}
