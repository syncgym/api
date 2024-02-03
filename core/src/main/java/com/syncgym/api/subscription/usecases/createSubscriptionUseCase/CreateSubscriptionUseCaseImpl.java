package com.syncgym.api.subscription.usecases.createSubscriptionUseCase;

import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.commonUser.usecases.getByUsernameCommonUserUseCase.GetByUsernameCommonUserUseCase;
import com.syncgym.api.plan.exceptions.PlanNotFoundException;
import com.syncgym.api.plan.usecases.getPlanByNameUseCase.GetPlanByNameUseCase;
import com.syncgym.api.subscription.Subscription;
import com.syncgym.api.subscription.ports.SubscriptionRepositoryService;

import java.util.Date;

public class CreateSubscriptionUseCaseImpl implements CreateSubscriptionUseCase {

    private final SubscriptionRepositoryService subscriptionRepositoryService;

    private final GetPlanByNameUseCase getPlanByNameUseCase;

    private final GetByUsernameCommonUserUseCase getByUsernameCommonUserUseCase;

    public CreateSubscriptionUseCaseImpl(SubscriptionRepositoryService subscriptionRepositoryService, GetPlanByNameUseCase getPlanByNameUseCase, GetByUsernameCommonUserUseCase getByUsernameCommonUserUseCase) {
        this.subscriptionRepositoryService = subscriptionRepositoryService;
        this.getPlanByNameUseCase = getPlanByNameUseCase;
        this.getByUsernameCommonUserUseCase = getByUsernameCommonUserUseCase;
    }

    @Override
    public Subscription execute(String planName, String userUsername, int monthsDuration) throws PlanNotFoundException, CommonUserNotFoundException {
        var plan = getPlanByNameUseCase.execute(planName);
        var user = getByUsernameCommonUserUseCase.execute(userUsername);

        var expireDate = new Date(System.currentTimeMillis() + (monthsDuration * 30L * 24L * 60L * 60L * 1000L));

        var subscription = new Subscription(null, plan, user, new Date(), expireDate);

        return subscriptionRepositoryService.saveSubscription(subscription);
    }
}
