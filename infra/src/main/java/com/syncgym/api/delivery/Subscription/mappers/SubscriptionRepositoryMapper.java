package com.syncgym.api.delivery.Subscription.mappers;

import com.syncgym.api.delivery.CommonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.Subscription.entities.SubscriptionEntity;
import com.syncgym.api.delivery.plan.mappers.PlanRepositoryMapper;
import com.syncgym.api.shared.RepositoryMapper;
import com.syncgym.api.subscription.Subscription;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionRepositoryMapper implements RepositoryMapper<SubscriptionEntity, Subscription> {

    @Autowired
    private PlanRepositoryMapper planRepositoryMapper;

    @Autowired
    private CommonUserRepositoryMapper commonUserRepositoryMapper;

    @Override
    public SubscriptionEntity mapToTable(final Subscription subscription) {
        return new SubscriptionEntity(
                subscription.id(),
                planRepositoryMapper.mapToTable(subscription.plan()),
                commonUserRepositoryMapper.mapToTable(subscription.commonUser()),
                subscription.startDate(),
                subscription.endDate()
        );
    }

    @Override
    public Subscription mapToEntity(final SubscriptionEntity subscriptionEntity) {
        return new Subscription(
                subscriptionEntity.getId(),
                planRepositoryMapper.mapToEntity(subscriptionEntity.getPlan()),
                commonUserRepositoryMapper.mapToEntity(subscriptionEntity.getCommonUser()),
                subscriptionEntity.getStartDate(),
                subscriptionEntity.getEndDate()
        );
    }
}
