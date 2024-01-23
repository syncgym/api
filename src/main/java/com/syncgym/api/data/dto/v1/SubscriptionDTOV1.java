package com.syncgym.api.data.dto.v1;

import com.syncgym.api.models.Plan;

import java.util.Date;

public record SubscriptionDTOV1(
        long id,
        Plan plan,
        Date startDate,
        Date endDate
) { }
