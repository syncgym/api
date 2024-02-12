package com.syncgym.api.delivery.plan.impl;

import com.syncgym.api.delivery.plan.PlanController;
import com.syncgym.api.delivery.plan.mappers.PlanRestMapper;
import com.syncgym.api.delivery.plan.responses.CreatePlanResponse;
import com.syncgym.api.delivery.plan.responses.GetPlansResponse;
import com.syncgym.api.delivery.plan.rest.PlanRest;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.exceptions.PlanAlreadyExistException;
import com.syncgym.api.plan.usecases.createPlanUseCase.CreatePlanUseCase;
import com.syncgym.api.plan.usecases.getAllPlansUseCase.GetAllPlansUseCase;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/plan")
@Tag(name = "Plan", description = "Endpoint for plan management")
public class PlanControllerImpl implements PlanController {

    @Autowired
    private GetAllPlansUseCase getAllPlansUseCase;

    @Autowired
    private CreatePlanUseCase createPlanUseCase;

    @Autowired
    private PlanRestMapper planReqMapper;

    @Override
    @Operation(summary = "Find all", description = "Find all plans",
            tags = {"Plan"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = GetPlansResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    @GetMapping
    public ResponseEntity<SyncgymResponse<List<String>>> getPlans() {
        var res = new SyncgymResponse<>(CommonConstants.OK, CommonConstants.OK_STATUS, CommonConstants.SUCCESS_MESSAGE,
                getAllPlansUseCase.execute().stream().map(Plan::name)
                        .collect(Collectors.toList()));

        return ResponseEntity.ok(res);
    }

    @Override
    @Operation(summary = "Create", description = "Create plan",
            tags = {"Plan"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(schema = @Schema(implementation = CreatePlanResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    @PostMapping
    public ResponseEntity<SyncgymResponse<PlanRest>> createPlan(@Valid @RequestBody final PlanRest plan) throws SyncgymException {
        try {
            createPlanUseCase.execute(planReqMapper.mapToDomain(plan));
        } catch (PlanAlreadyExistException e) {
            throw new BadRequestException("Plan already exists");
        }

        var res = new SyncgymResponse<>(CommonConstants.CREATED, CommonConstants.CREATED_STATUS, CommonConstants.SUCCESS_MESSAGE, plan);


        return ResponseEntity.status(CommonConstants.CREATED_STATUS).body(res);
    }
}
