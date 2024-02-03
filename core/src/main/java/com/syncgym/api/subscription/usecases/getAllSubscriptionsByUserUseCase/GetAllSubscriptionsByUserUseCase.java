package com.syncgym.api.subscription.usecases.getAllSubscriptionsByUserUseCase;

import com.syncgym.api.subscription.Subscription;

import java.util.Collection;

public interface GetAllSubscriptionsByUserUseCase {

    Collection<Subscription> execute(String useraname);
}
