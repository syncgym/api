package com.syncgym.api.delivery.userWorkout.responses;

import com.syncgym.api.delivery.userWorkout.rest.UserWorkoutResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class ListOfUserWorkoutResponse extends SyncgymResponse<List<UserWorkoutResponseRest>> {

    public ListOfUserWorkoutResponse(String status, int code, String message, List<UserWorkoutResponseRest> data) {
        super(status, code, message, data);
    }
}
