package com.syncgym.api.delivery.exercise.responses;

import com.syncgym.api.delivery.exercise.rest.ExerciseResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class ListOfExerciseResponse extends SyncgymResponse<List<ExerciseResponseRest>> {

    public ListOfExerciseResponse(String status, int code, String message, List<ExerciseResponseRest> data) {
        super(status, code, message, data);
    }
}
