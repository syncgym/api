package com.syncgym.api.subscription;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.plan.Plan;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record Subscription(Long id, Plan plan, CommonUser commonUser, Date startDate,
                           Date endDate) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
