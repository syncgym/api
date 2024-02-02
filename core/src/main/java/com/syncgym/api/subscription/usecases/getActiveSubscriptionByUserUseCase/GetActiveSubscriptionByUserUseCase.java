package com.syncgym.api.subscription.usecases.getActiveSubscriptionByUserUseCase;

import com.syncgym.api.subscription.Subscription;
import com.syncgym.api.subscription.exceptions.SubscriptionNotFoundException;

public interface GetActiveSubscriptionByUserUseCase {

    Subscription execute(Long id) throws SubscriptionNotFoundException;
}
