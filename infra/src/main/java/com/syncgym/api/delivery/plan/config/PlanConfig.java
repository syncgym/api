package com.syncgym.api.delivery.plan.config;

import com.syncgym.api.delivery.plan.impl.PlanServiceImpl;
import com.syncgym.api.delivery.plan.mappers.PlanRepositoryMapper;
import com.syncgym.api.delivery.plan.mappers.PlanReqMapper;
import com.syncgym.api.delivery.plan.repositories.PlanRepository;
import com.syncgym.api.plan.usecases.createPlanUseCase.CreatePlanUseCaseImpl;
import com.syncgym.api.plan.usecases.getAllPlansUseCase.GetAllPlansUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanConfig {

    @Autowired
    private PlanRepository planRepository;

    @Bean
    public PlanRepositoryMapper planRepositoryMapper() {
        return new PlanRepositoryMapper();
    }

    @Bean
    public PlanReqMapper planReqMapper() {
        return new PlanReqMapper();
    }

    @Bean
    public PlanServiceImpl planService() {
        return new PlanServiceImpl(planRepository, planRepositoryMapper());
    }

    @Bean
    public GetAllPlansUseCaseImpl getAllPlansUseCase() {
        return new GetAllPlansUseCaseImpl(planService());
    }

    @Bean
    CreatePlanUseCaseImpl createPlanUseCase() {
        return new CreatePlanUseCaseImpl(planService());
    }
}
