package com.syncgym.api.commonUser.exceptions;

public class CommonUserNotFoundException extends Exception {

    public CommonUserNotFoundException() {
        super("CommonUser not found");
    }
}
