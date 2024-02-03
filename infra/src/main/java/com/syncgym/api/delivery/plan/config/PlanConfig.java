package com.syncgym.api.delivery.plan.config;

import com.syncgym.api.delivery.plan.impl.PlanServiceImpl;
import com.syncgym.api.delivery.plan.mappers.PlanRepositoryMapper;
import com.syncgym.api.delivery.plan.mappers.PlanRestMapper;
import com.syncgym.api.plan.usecases.createPlanUseCase.CreatePlanUseCaseImpl;
import com.syncgym.api.plan.usecases.getAllPlansUseCase.GetAllPlansUseCaseImpl;
import com.syncgym.api.plan.usecases.getPlanByNameUseCase.GetPlanByNameUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanConfig {

    @Bean
    public PlanRepositoryMapper planRepositoryMapper() {
        return new PlanRepositoryMapper();
    }

    @Bean
    public PlanRestMapper planReqMapper() {
        return new PlanRestMapper();
    }

    @Bean
    public PlanServiceImpl planService() {
        return new PlanServiceImpl();
    }

    @Bean
    public GetAllPlansUseCaseImpl getAllPlansUseCase() {
        return new GetAllPlansUseCaseImpl(planService());
    }

    @Bean
    public CreatePlanUseCaseImpl createPlanUseCase() {
        return new CreatePlanUseCaseImpl(planService());
    }

    @Bean
    public GetPlanByNameUseCaseImpl getPlanByNameUseCase() {
        return new GetPlanByNameUseCaseImpl(planService());
    }
}
