package com.syncgym.api.delivery.userWorkout.impl;

import com.syncgym.api.delivery.userWorkout.UserWorkoutController;
import com.syncgym.api.delivery.userWorkout.mappers.UserWorkoutResponseRestMapper;
import com.syncgym.api.delivery.userWorkout.responses.ListOfUserWorkoutResponse;
import com.syncgym.api.delivery.userWorkout.responses.UserWorkoutResponse;
import com.syncgym.api.delivery.userWorkout.rest.UserWorkoutResponseRest;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
import com.syncgym.api.userWorkout.exceptions.UserWorkoutNotFoundException;
import com.syncgym.api.userWorkout.usecases.getActiveWorkoutByUserUsernameUseCase.GetActiveWorkoutByUserUsernameUseCase;
import com.syncgym.api.userWorkout.usecases.getAllWorkoutsByUserUsernameUseCase.GetAllWorkoutsByUserUsernameUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userWorkout")
@Tag(name = "UserWorkout", description = "Endpoint for user workouts management")
public class UserWorkoutControllerImpl implements UserWorkoutController {

    @Autowired
    private UserWorkoutResponseRestMapper userWorkoutResponseRestMapper;

    @Autowired
    private GetActiveWorkoutByUserUsernameUseCase getActiveWorkoutByUserUsernameUseCase;

    @Autowired
    private GetAllWorkoutsByUserUsernameUseCase getAllWorkoutsByUserUsernameUseCase;

    @Override
    @GetMapping("/active/{username}")
    @Operation(summary = "Get active workout by user", description = "Get active workout by user",
            tags = {"UserWorkout"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = UserWorkoutResponse.class))),
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
    public ResponseEntity<SyncgymResponse<UserWorkoutResponseRest>> getActiveWorkout(@PathVariable("username") String username) throws SyncgymException {
        try {
            var workout = getActiveWorkoutByUserUsernameUseCase.execute(username);

            var res = new SyncgymResponse<>(
                    CommonConstants.OK,
                    CommonConstants.OK_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    userWorkoutResponseRestMapper.mapToRest(workout)
            );

            return ResponseEntity.ok(res);
        } catch (UserWorkoutNotFoundException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    @GetMapping("/{username}")
    @Operation(summary = "Get all workouts by user", description = "Get all workouts by user",
            tags = {"UserWorkout"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = ListOfUserWorkoutResponse.class))),
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
    public ResponseEntity<SyncgymResponse<List<UserWorkoutResponseRest>>> getAllWorkouts(@PathVariable("username") String username) throws SyncgymException {
        var workouts = getAllWorkoutsByUserUsernameUseCase.execute(username);

        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                workouts.stream().map(userWorkoutResponseRestMapper::mapToRest).toList()
        );

        return ResponseEntity.ok(res);
    }
}
