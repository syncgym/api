package com.syncgym.api.subscription.usecases.createSubscriptionUseCase;

import com.syncgym.api.subscription.Subscription;
import com.syncgym.api.subscription.ports.SubscriptionRepositoryService;

public class CreateSubscriptionUseCaseImpl implements CreateSubscriptionUseCase {

    private final SubscriptionRepositoryService subscriptionRepositoryService;

    public CreateSubscriptionUseCaseImpl(SubscriptionRepositoryService subscriptionRepositoryService) {
        this.subscriptionRepositoryService = subscriptionRepositoryService;
    }

    @Override
    public Subscription execute(Subscription subscription) {
        return subscriptionRepositoryService.saveSubscription(subscription);
    }
}
