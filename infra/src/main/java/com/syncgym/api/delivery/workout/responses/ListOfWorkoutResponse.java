package com.syncgym.api.delivery.workout.responses;

import com.syncgym.api.delivery.workout.rest.WorkoutResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class ListOfWorkoutResponse extends SyncgymResponse<List<WorkoutResponseRest>> {

    public ListOfWorkoutResponse(String status, int code, String message, List<WorkoutResponseRest> data) {
        super(status, code, message, data);
    }
}
