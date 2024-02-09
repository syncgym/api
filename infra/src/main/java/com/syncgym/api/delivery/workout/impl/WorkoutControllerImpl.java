package com.syncgym.api.delivery.workout.impl;

import com.syncgym.api.delivery.workout.WorkoutController;
import com.syncgym.api.delivery.workout.mappers.WorkoutResponseRestMapper;
import com.syncgym.api.delivery.workout.responses.ListOfWorkoutResponse;
import com.syncgym.api.delivery.workout.rest.WorkoutResponseRest;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
import com.syncgym.api.workout.usecases.getAllWorkoutsUseCase.GetAllWorkoutsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workout")
@Tag(name = "Workout", description = "Endpoint for workout management")
public class WorkoutControllerImpl implements WorkoutController {

    @Autowired
    private WorkoutResponseRestMapper workoutResponseRestMapper;

    @Autowired
    private GetAllWorkoutsUseCase getAllWorkoutsUseCase;

    @Override
    @GetMapping
    @Operation(summary = "Get all workouts", description = "Get all workouts",
            tags = {"Workout"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = ListOfWorkoutResponse.class))),
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
    public ResponseEntity<SyncgymResponse<List<WorkoutResponseRest>>> findAllWorkouts() throws SyncgymException {
        var workouts = getAllWorkoutsUseCase.execute();

        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                workouts.stream().map(workoutResponseRestMapper::mapToRest).toList()
        );

        return ResponseEntity.ok(res);
    }
}
