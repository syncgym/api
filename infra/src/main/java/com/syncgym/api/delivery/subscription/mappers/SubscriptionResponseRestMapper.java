package com.syncgym.api.delivery.subscription.mappers;

import com.syncgym.api.delivery.commonUser.mappers.CommonUserResponseRestMapper;
import com.syncgym.api.delivery.plan.mappers.PlanRestMapper;
import com.syncgym.api.delivery.subscription.rest.SubscriptionResponseRest;
import com.syncgym.api.shared.RestMapper;
import com.syncgym.api.subscription.Subscription;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionResponseRestMapper implements RestMapper<SubscriptionResponseRest, Subscription> {

    @Autowired
    private CommonUserResponseRestMapper commonUserResponseRestMapper;

    @Autowired
    private PlanRestMapper planRestMapper;

    @Override
    public SubscriptionResponseRest mapToRest(Subscription domain) {
        return new SubscriptionResponseRest(
                commonUserResponseRestMapper.mapToRest(domain.commonUser()),
                planRestMapper.mapToRest(domain.plan()),
                domain.startDate(),
                domain.endDate()
        );
    }
}
