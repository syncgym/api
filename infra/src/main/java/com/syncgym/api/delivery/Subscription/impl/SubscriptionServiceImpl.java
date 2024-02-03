package com.syncgym.api.delivery.Subscription.impl;

import com.syncgym.api.delivery.Subscription.mappers.SubscriptionRepositoryMapper;
import com.syncgym.api.delivery.Subscription.repositories.SubscriptionRepository;
import com.syncgym.api.subscription.Subscription;
import com.syncgym.api.subscription.ports.SubscriptionRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class SubscriptionServiceImpl implements SubscriptionRepositoryService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionRepositoryMapper subscriptionRepositoryMapper;

    @Override
    public Collection<Subscription> getAllSubscriptionsByUser(String username) {
        return subscriptionRepository.findAllByCommonUserUserUsername(username)
                .stream().map(subscriptionRepositoryMapper::mapToEntity).toList();
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepositoryMapper
                .mapToEntity(subscriptionRepository.save(subscriptionRepositoryMapper.mapToTable(subscription)));
    }
}
