package com.syncgym.api.delivery.workout;

import com.syncgym.api.delivery.workout.rest.WorkoutResponseRest;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutController {

    ResponseEntity<SyncgymResponse<List<WorkoutResponseRest>>> findAllWorkouts() throws SyncgymException;
}
