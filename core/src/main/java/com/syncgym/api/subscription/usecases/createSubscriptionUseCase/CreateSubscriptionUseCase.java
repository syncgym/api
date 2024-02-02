package com.syncgym.api.subscription.usecases.createSubscriptionUseCase;

import com.syncgym.api.subscription.Subscription;

public interface CreateSubscriptionUseCase {

    Subscription execute(Subscription subscription);
}
