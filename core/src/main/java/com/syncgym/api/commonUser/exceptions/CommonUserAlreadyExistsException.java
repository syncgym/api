package com.syncgym.api.commonUser.exceptions;

public class CommonUserAlreadyExistsException extends Exception {

    public CommonUserAlreadyExistsException() {
        super("Common user already exists");
    }
}
