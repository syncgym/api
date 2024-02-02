package com.syncgym.api.subscription.exceptions;

public class SubscriptionNotFoundException extends Exception {

    public SubscriptionNotFoundException() {
        super("User don't have an active subscription");
    }
}
