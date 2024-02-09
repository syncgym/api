package com.syncgym.api.delivery.userWorkout;

import com.syncgym.api.delivery.userWorkout.rest.UserWorkoutResponseRest;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserWorkoutController {

    ResponseEntity<SyncgymResponse<UserWorkoutResponseRest>> getActiveWorkout(String username) throws SyncgymException;

    ResponseEntity<SyncgymResponse<List<UserWorkoutResponseRest>>> getAllWorkouts(String username) throws SyncgymException;
}
