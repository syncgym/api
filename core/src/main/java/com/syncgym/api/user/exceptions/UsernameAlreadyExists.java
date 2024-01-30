package com.syncgym.api.user.exceptions;

public class UsernameAlreadyExists extends Exception {

    public UsernameAlreadyExists(String username) {
        super("Username already exists, username: " + username + " is already taken");
    }
}
