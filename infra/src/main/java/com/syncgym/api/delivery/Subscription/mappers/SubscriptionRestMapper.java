package com.syncgym.api.delivery.Subscription.mappers;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.delivery.Subscription.rest.SubscriptionRest;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.shared.RestMapper;
import com.syncgym.api.subscription.Subscription;

public class SubscriptionRestMapper implements RestMapper<SubscriptionRest, Subscription> {

    @Override
    public Subscription mapToEntity(final SubscriptionRest rest) {
        return new Subscription(
                null,
                new Plan(rest.planId(), null, 0),
                new CommonUser(rest.userId(), null, null, null, null, null, null),
                null,
                null
        );
    }

    @Override
    public SubscriptionRest mapToRest(final Subscription entity) {
        return new SubscriptionRest(entity.plan().id(), entity.commonUser().id());
    }
}
