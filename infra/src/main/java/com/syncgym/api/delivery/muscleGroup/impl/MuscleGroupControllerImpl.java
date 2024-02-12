package com.syncgym.api.delivery.muscleGroup.impl;

import com.syncgym.api.delivery.muscleGroup.MuscleGroupController;
import com.syncgym.api.delivery.muscleGroup.responses.ListOfMuscleGroupResponse;
import com.syncgym.api.delivery.muscleGroup.rest.CreateMuscleGroupReqRest;
import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupAlreadyExistsException;
import com.syncgym.api.muscleGroup.usecases.createMuscleGroupUseCase.CreateMuscleGroupUseCase;
import com.syncgym.api.muscleGroup.usecases.getAllMuscleGroupsUseCase.GetAllMuscleGroupsUseCase;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/muscle-group")
@Tag(name = "Muscle Group", description = "Endpoint for muscle group management")
public class MuscleGroupControllerImpl implements MuscleGroupController {

    @Autowired
    private GetAllMuscleGroupsUseCase getAllMuscleGroupsUseCase;

    @Autowired
    private CreateMuscleGroupUseCase createMuscleGroupUseCase;

    @Override
    @GetMapping
    @Operation(summary = "Find all muscle groups", description = "Find all muscle groups",
            tags = {"Muscle Group"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = ListOfMuscleGroupResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    public ResponseEntity<SyncgymResponse<List<String>>> getAllMuscleGroups() throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                getAllMuscleGroupsUseCase.execute()
                        .stream().map(MuscleGroup::name).toList()
        );

        return ResponseEntity.ok(res);
    }

    @Override
    @PostMapping
    @Operation(summary = "Create a muscle group", description = "Create a muscle group",
            tags = {"Muscle Group"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(schema = @Schema(implementation = ListOfMuscleGroupResponse.class))),
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
    public ResponseEntity<SyncgymResponse<String>> createMuscleGroup(@Valid @RequestBody CreateMuscleGroupReqRest req) throws SyncgymException {
        try {
            var res = new SyncgymResponse<>(
                    CommonConstants.CREATED,
                    CommonConstants.CREATED_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    createMuscleGroupUseCase.execute(req.name()).name()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (MuscleGroupAlreadyExistsException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
