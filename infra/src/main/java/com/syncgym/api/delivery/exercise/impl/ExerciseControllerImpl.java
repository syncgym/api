package com.syncgym.api.delivery.exercise.impl;

import com.syncgym.api.delivery.exercise.ExerciseController;
import com.syncgym.api.delivery.exercise.mappers.ExerciseResponseRestMapper;
import com.syncgym.api.delivery.exercise.responses.ListOfExerciseResponse;
import com.syncgym.api.delivery.exercise.rest.ExerciseResponseRest;
import com.syncgym.api.exercise.usecases.getAllExercisesByMuscleGroupUseCase.GetAllExercisesByMuscleGroupUseCase;
import com.syncgym.api.exercise.usecases.getAllExercisesByTargetMuscleGroupUseCase.GetAllExercisesByTargetMuscleGroupUseCase;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
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
@RequestMapping("/api/v1/exercise")
@Tag(name = "Exercise", description = "Endpoint for exercise management")
public class ExerciseControllerImpl implements ExerciseController {

    @Autowired
    private GetAllExercisesByMuscleGroupUseCase getAllExercisesByMuscleGroupUseCase;

    @Autowired
    private GetAllExercisesByTargetMuscleGroupUseCase getAllExercisesByTargetMuscleGroupUseCase;

    @Autowired
    private ExerciseResponseRestMapper exerciseResponseRestMapper;

    @Override
    @GetMapping("/muscle-group/{name}")
    @Operation(summary = "Find all exercises by muscle group", description = "Find all exercises by muscle group name",
            tags = {"Exercise"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = ListOfExerciseResponse.class))),
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
    public ResponseEntity<SyncgymResponse<List<ExerciseResponseRest>>> getAllExercisesByMuscleGroup(@PathVariable("name") String name) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                getAllExercisesByMuscleGroupUseCase.execute(name)
                        .stream().map(exerciseResponseRestMapper::mapToRest).toList()
        );

        return ResponseEntity.ok(res);
    }

    @Override
    @GetMapping("/muscle-group/target/{name}")
    @Operation(summary = "Find all exercises by target muscle group", description = "Find all exercises by target muscle group name",
            tags = {"Exercise"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = ListOfExerciseResponse.class))),
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
    public ResponseEntity<SyncgymResponse<List<ExerciseResponseRest>>> getAllExercisesByTargetMuscleGroup(@PathVariable("name") String name) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                getAllExercisesByTargetMuscleGroupUseCase.execute(name)
                        .stream().map(exerciseResponseRestMapper::mapToRest).toList()
        );

        return ResponseEntity.ok(res);
    }
}
