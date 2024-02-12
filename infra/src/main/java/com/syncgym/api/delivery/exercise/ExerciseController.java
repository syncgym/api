package com.syncgym.api.delivery.exercise;

import com.syncgym.api.delivery.exercise.rest.ExerciseResponseRest;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExerciseController {

    ResponseEntity<SyncgymResponse<List<ExerciseResponseRest>>> getAllExercises() throws SyncgymException;

    ResponseEntity<SyncgymResponse<List<ExerciseResponseRest>>> getAllExercisesByMuscleGroup(String name) throws SyncgymException;

    ResponseEntity<SyncgymResponse<List<ExerciseResponseRest>>> getAllExercisesByTargetMuscleGroup(String name) throws SyncgymException;
}
