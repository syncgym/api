package com.syncgym.api.subscription.ports;

import com.syncgym.api.subscription.Subscription;

import java.util.Collection;

public interface SubscriptionRepositoryService {

    Collection<Subscription> getAllSubscriptionsByUser(String username);

    Subscription saveSubscription(Subscription subscription);
}
