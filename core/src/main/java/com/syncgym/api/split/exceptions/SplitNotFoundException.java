package com.syncgym.api.split.exceptions;

public class SplitNotFoundException extends Exception {

    public SplitNotFoundException() {
        super("Split not found");
    }
}
