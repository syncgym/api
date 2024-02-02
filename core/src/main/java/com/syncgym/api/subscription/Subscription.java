package com.syncgym.api.subscription;

import com.syncgym.api.plan.Plan;
import com.syncgym.api.user.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record Subscription(Long id, User user, Plan plan, Date startDate, Date endDate) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
