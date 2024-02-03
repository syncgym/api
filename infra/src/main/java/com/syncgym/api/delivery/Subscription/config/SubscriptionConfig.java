package com.syncgym.api.delivery.Subscription.config;

import com.syncgym.api.delivery.Subscription.impl.SubscriptionServiceImpl;
import com.syncgym.api.delivery.Subscription.mappers.SubscriptionRepositoryMapper;
import com.syncgym.api.delivery.Subscription.mappers.SubscriptionResponseRestMapper;
import com.syncgym.api.delivery.Subscription.mappers.SubscriptionRestMapper;
import com.syncgym.api.subscription.usecases.createSubscriptionUseCase.CreateSubscriptionUseCaseImpl;
import com.syncgym.api.subscription.usecases.getActiveSubscriptionByUserUseCase.GetActiveSubscriptionByUserUseCaseImpl;
import com.syncgym.api.subscription.usecases.getAllSubscriptionsByUserUseCase.GetAllSubscriptionsByUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionConfig {

    @Bean
    public SubscriptionRepositoryMapper subscriptionRepositoryMapper() {
        return new SubscriptionRepositoryMapper();
    }

    @Bean
    public SubscriptionRestMapper subscriptionRestMapper() {
        return new SubscriptionRestMapper();
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
        return new CreateSubscriptionUseCaseImpl(subscriptionService());
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
