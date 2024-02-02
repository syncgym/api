package com.syncgym.api.subscription.usecases.getActiveSubscriptionByUserUseCase;

import com.syncgym.api.subscription.Subscription;
import com.syncgym.api.subscription.exceptions.SubscriptionNotFoundException;
import com.syncgym.api.subscription.ports.SubscriptionRepositoryService;

public class GetActiveSubscriptionByUserUseCaseImpl implements GetActiveSubscriptionByUserUseCase {

    private final SubscriptionRepositoryService subscriptionRepositoryService;

    public GetActiveSubscriptionByUserUseCaseImpl(SubscriptionRepositoryService subscriptionRepositoryService) {
        this.subscriptionRepositoryService = subscriptionRepositoryService;
    }

    @Override
    public Subscription execute(Long id) throws SubscriptionNotFoundException {
        return subscriptionRepositoryService.getActiveSubscriptionByUser(id)
                .orElseThrow(SubscriptionNotFoundException::new);
    }
}
