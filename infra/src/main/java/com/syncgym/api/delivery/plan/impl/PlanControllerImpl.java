package com.syncgym.api.delivery.plan.impl;

import com.syncgym.api.delivery.plan.PlanController;
import com.syncgym.api.delivery.plan.mappers.PlanReqMapper;
import com.syncgym.api.delivery.plan.requests.PlanReq;
import com.syncgym.api.plan.exceptions.PlanAlreadyExistException;
import com.syncgym.api.plan.usecases.createPlanUseCase.CreatePlanUseCase;
import com.syncgym.api.plan.usecases.getAllPlansUseCase.GetAllPlansUseCase;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/plan")
@Tag(name = "Plan", description = "Endpoint for plan management")
public class PlanControllerImpl implements PlanController {

    private final GetAllPlansUseCase getAllPlansUseCase;

    private final CreatePlanUseCase createPlanUseCase;

    private final PlanReqMapper planReqMapper;

    public PlanControllerImpl(GetAllPlansUseCase getAllPlansUseCase, CreatePlanUseCase createPlanUseCase, PlanReqMapper planReqMapper) {
        this.getAllPlansUseCase = getAllPlansUseCase;
        this.createPlanUseCase = createPlanUseCase;
        this.planReqMapper = planReqMapper;
    }

    @Override
    @GetMapping

    public SyncgymResponse<Collection<PlanReq>> getPlans() throws SyncgymException {
        return new SyncgymResponse<>(CommonConstants.SUCCESS, HttpStatus.OK.value(), CommonConstants.OK,
                getAllPlansUseCase.execute().stream().map(planReqMapper::mapToReq)
                        .collect(Collectors.toList()));
    }

    @Override
    @PostMapping
    public SyncgymResponse<PlanReq> createPlan(@Valid @RequestBody final PlanReq plan) throws SyncgymException {
        try {
            createPlanUseCase.execute(planReqMapper.mapToEntity(plan));
        } catch (PlanAlreadyExistException e) {
            throw new BadRequestException("Plan already exists");
        }

        return new SyncgymResponse<>(CommonConstants.SUCCESS, HttpStatus.OK.value(), CommonConstants.OK, plan);
    }
}
