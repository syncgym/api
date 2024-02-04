package com.syncgym.api.delivery.subscription.impl;

import com.syncgym.api.delivery.subscription.mappers.SubscriptionRepositoryMapper;
import com.syncgym.api.delivery.subscription.repositories.SubscriptionRepository;
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
                .stream().map(subscriptionRepositoryMapper::mapToDomain).toList();
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepositoryMapper
                .mapToDomain(subscriptionRepository.save(subscriptionRepositoryMapper.mapToEntity(subscription)));
    }
}
