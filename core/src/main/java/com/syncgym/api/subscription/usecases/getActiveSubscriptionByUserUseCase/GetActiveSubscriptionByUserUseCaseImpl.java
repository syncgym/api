package com.syncgym.api.subscription.usecases.getActiveSubscriptionByUserUseCase;

import com.syncgym.api.subscription.Subscription;
import com.syncgym.api.subscription.exceptions.SubscriptionNotFoundException;
import com.syncgym.api.subscription.ports.SubscriptionRepositoryService;

import java.util.Date;

public class GetActiveSubscriptionByUserUseCaseImpl implements GetActiveSubscriptionByUserUseCase {

    private final SubscriptionRepositoryService subscriptionRepositoryService;

    public GetActiveSubscriptionByUserUseCaseImpl(SubscriptionRepositoryService subscriptionRepositoryService) {
        this.subscriptionRepositoryService = subscriptionRepositoryService;
    }

    @Override
    public Subscription execute(String username) throws SubscriptionNotFoundException {
        var actualDate = new Date();

        return subscriptionRepositoryService.getAllSubscriptionsByUser(username)
                .stream()
                .filter(subscription -> subscription.endDate().after(actualDate) && subscription.startDate().before(actualDate))
                .findFirst()
                .orElseThrow(SubscriptionNotFoundException::new);
    }
}
