package com.syncgym.api.delivery.subscription.rest;

import com.syncgym.api.delivery.commonUser.rest.CommonUserResponseRest;
import com.syncgym.api.delivery.plan.rest.PlanRest;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record SubscriptionResponseRest(
        CommonUserResponseRest user,
        PlanRest plan,
        Date startDate,
        Date endDate
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
