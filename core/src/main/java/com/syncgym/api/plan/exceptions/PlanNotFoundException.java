package com.syncgym.api.plan.exceptions;

public class PlanNotFoundException extends Exception {

    public PlanNotFoundException(String message) {
        super(message);
    }

    public PlanNotFoundException() {
        super("Plan not found");
    }
}
