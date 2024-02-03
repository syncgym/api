package com.syncgym.api.subscription.usecases.createSubscriptionUseCase;

import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.plan.exceptions.PlanNotFoundException;
import com.syncgym.api.subscription.Subscription;

public interface CreateSubscriptionUseCase {

    Subscription execute(String planName, String userUsername, int monthsDuration) throws PlanNotFoundException, CommonUserNotFoundException;
}
