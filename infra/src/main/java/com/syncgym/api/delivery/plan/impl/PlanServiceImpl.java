package com.syncgym.api.delivery.plan.impl;

import com.syncgym.api.delivery.plan.mappers.PlanRepositoryMapper;
import com.syncgym.api.delivery.plan.repositories.PlanRepository;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.ports.PlanRepositoryService;

import java.util.Collection;
import java.util.stream.Collectors;

public class PlanServiceImpl implements PlanRepositoryService {

    private final PlanRepository planRepository;

    private final PlanRepositoryMapper planRepositoryMapper;

    public PlanServiceImpl(PlanRepository planRepository, PlanRepositoryMapper planRepositoryMapper) {
        this.planRepository = planRepository;
        this.planRepositoryMapper = planRepositoryMapper;
    }

    @Override
    public Collection<Plan> getAllPlans() {
        return planRepository.findAll().stream().map(planRepositoryMapper::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void savePlan(Plan plan) {
        planRepository.save(planRepositoryMapper.mapToTable(plan));
    }

    @Override
    public Boolean doesPlanNameExists(String name) {
        return !planRepository.findByName(name).isEmpty();
    }
}
