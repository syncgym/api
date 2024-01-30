package com.syncgym.api.permission.exceptions;

public class PermissionsNotFoundException extends Exception {

    public PermissionsNotFoundException() {
        super("Permissions not found");
    }
}
