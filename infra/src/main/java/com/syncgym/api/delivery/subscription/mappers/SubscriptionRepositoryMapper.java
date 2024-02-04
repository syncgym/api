package com.syncgym.api.delivery.subscription.mappers;

import com.syncgym.api.delivery.commonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.plan.mappers.PlanRepositoryMapper;
import com.syncgym.api.delivery.subscription.entities.SubscriptionEntity;
import com.syncgym.api.shared.RepositoryMapper;
import com.syncgym.api.subscription.Subscription;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionRepositoryMapper implements RepositoryMapper<SubscriptionEntity, Subscription> {

    @Autowired
    private PlanRepositoryMapper planRepositoryMapper;

    @Autowired
    private CommonUserRepositoryMapper commonUserRepositoryMapper;

    @Override
    public SubscriptionEntity mapToEntity(final Subscription domain) {
        return new SubscriptionEntity(
                domain.id(),
                planRepositoryMapper.mapToEntity(domain.plan()),
                commonUserRepositoryMapper.mapToEntity(domain.commonUser()),
                domain.startDate(),
                domain.endDate()
        );
    }

    @Override
    public Subscription mapToDomain(final SubscriptionEntity entity) {
        return new Subscription(
                entity.getId(),
                planRepositoryMapper.mapToDomain(entity.getPlan()),
                commonUserRepositoryMapper.mapToDomain(entity.getCommonUser()),
                entity.getStartDate(),
                entity.getEndDate()
        );
    }
}
