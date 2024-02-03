package com.syncgym.api.subscription.usecases.getAllSubscriptionsByUserUseCase;

import com.syncgym.api.subscription.Subscription;
import com.syncgym.api.subscription.ports.SubscriptionRepositoryService;

import java.util.Collection;

public class GetAllSubscriptionsByUserUseCaseImpl implements GetAllSubscriptionsByUserUseCase {

    private final SubscriptionRepositoryService subscriptionRepositoryService;

    public GetAllSubscriptionsByUserUseCaseImpl(SubscriptionRepositoryService subscriptionRepositoryService) {
        this.subscriptionRepositoryService = subscriptionRepositoryService;
    }

    @Override
    public Collection<Subscription> execute(String username) {
        return subscriptionRepositoryService.getAllSubscriptionsByUser(username);
    }
}
