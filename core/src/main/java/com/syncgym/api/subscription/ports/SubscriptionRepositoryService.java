package com.syncgym.api.subscription.ports;

import com.syncgym.api.subscription.Subscription;

import java.util.Collection;
import java.util.Optional;

public interface SubscriptionRepositoryService {

    Collection<Subscription> getAllSubscriptionsByUser(Long id);

    Subscription saveSubscription(Subscription subscription);

    Optional<Subscription> getActiveSubscriptionByUser(Long id);
}

