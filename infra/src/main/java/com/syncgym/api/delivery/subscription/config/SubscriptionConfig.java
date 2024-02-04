package com.syncgym.api.delivery.subscription.config;

import com.syncgym.api.commonUser.usecases.getByUsernameCommonUserUseCase.GetByUsernameCommonUserUseCase;
import com.syncgym.api.delivery.subscription.impl.SubscriptionServiceImpl;
import com.syncgym.api.delivery.subscription.mappers.SubscriptionRepositoryMapper;
import com.syncgym.api.delivery.subscription.mappers.SubscriptionResponseRestMapper;
import com.syncgym.api.plan.usecases.getPlanByNameUseCase.GetPlanByNameUseCase;
import com.syncgym.api.subscription.usecases.createSubscriptionUseCase.CreateSubscriptionUseCaseImpl;
import com.syncgym.api.subscription.usecases.getActiveSubscriptionByUserUseCase.GetActiveSubscriptionByUserUseCaseImpl;
import com.syncgym.api.subscription.usecases.getAllSubscriptionsByUserUseCase.GetAllSubscriptionsByUserUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionConfig {

    @Autowired
    private GetPlanByNameUseCase getPlanByNameUseCase;

    @Autowired
    private GetByUsernameCommonUserUseCase getByUsernameCommonUserUseCase;

    @Bean
    public SubscriptionRepositoryMapper subscriptionRepositoryMapper() {
        return new SubscriptionRepositoryMapper();
    }

    @Bean
    public SubscriptionResponseRestMapper subscriptionResponseRestMapper() {
        return new SubscriptionResponseRestMapper();
    }

    @Bean
    public SubscriptionServiceImpl subscriptionService() {
        return new SubscriptionServiceImpl();
    }

    @Bean
    public CreateSubscriptionUseCaseImpl createSubscriptionUseCase() {
        return new CreateSubscriptionUseCaseImpl(subscriptionService(), getPlanByNameUseCase, getByUsernameCommonUserUseCase);
    }

    @Bean
    public GetAllSubscriptionsByUserUseCaseImpl getAllSubscriptionsByUserUseCase() {
        return new GetAllSubscriptionsByUserUseCaseImpl(subscriptionService());
    }

    @Bean
    public GetActiveSubscriptionByUserUseCaseImpl getActiveSubscriptionByUserUseCase() {
        return new GetActiveSubscriptionByUserUseCaseImpl(subscriptionService());
    }
}
