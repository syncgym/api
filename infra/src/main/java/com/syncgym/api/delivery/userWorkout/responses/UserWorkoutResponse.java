package com.syncgym.api.delivery.userWorkout.responses;

import com.syncgym.api.delivery.userWorkout.rest.UserWorkoutResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class UserWorkoutResponse extends SyncgymResponse<UserWorkoutResponseRest> {

    public UserWorkoutResponse(String status, int code, String message, UserWorkoutResponseRest data) {
        super(status, code, message, data);
    }
}
