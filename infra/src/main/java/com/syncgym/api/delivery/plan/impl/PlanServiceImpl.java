package com.syncgym.api.delivery.plan.impl;

import com.syncgym.api.delivery.plan.mappers.PlanRepositoryMapper;
import com.syncgym.api.delivery.plan.repositories.PlanRepository;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.ports.PlanRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlanServiceImpl implements PlanRepositoryService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanRepositoryMapper planRepositoryMapper;

    @Override
    public Collection<Plan> getAllPlans() {
        return planRepository.findAll().stream().map(planRepositoryMapper::mapToDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Plan> getPlanByName(String name) {
        return planRepository.findByName(name)
                .map(planRepositoryMapper::mapToDomain);
    }

    @Override
    public void savePlan(Plan plan) {
        planRepository.save(planRepositoryMapper.mapToEntity(plan));
    }

    @Override
    public Boolean doesPlanNameExists(String name) {
        return planRepository.findByName(name).isPresent();
    }
}
