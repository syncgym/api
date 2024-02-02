package com.syncgym.api.security.services.signUpService;

import com.syncgym.api.security.rest.AccountCredentials;
import com.syncgym.api.security.rest.Token;
import com.syncgym.api.shared.exceptions.SyncgymException;

public interface SignUpService {

    Token execute(AccountCredentials accountCredentials) throws SyncgymException;
}
