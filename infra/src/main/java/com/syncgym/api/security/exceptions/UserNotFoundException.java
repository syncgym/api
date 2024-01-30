package com.syncgym.api.security.exceptions;

import com.syncgym.api.shared.exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super("User not found");
    }
}
