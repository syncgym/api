package com.syncgym.api.plan.exceptions;

public class PlanAlreadyExistException extends Exception {

    public PlanAlreadyExistException(String message) {
        super(message);
    }

    public PlanAlreadyExistException() {
        super("Plan already exists");
    }
}
