package com.syncgym.api.delivery.muscleGroup;

import com.syncgym.api.delivery.muscleGroup.rest.CreateMuscleGroupReqRest;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MuscleGroupController {

    ResponseEntity<SyncgymResponse<List<String>>> getAllMuscleGroups() throws SyncgymException;

    ResponseEntity<SyncgymResponse<String>> createMuscleGroup(CreateMuscleGroupReqRest req) throws SyncgymException;

    ResponseEntity<SyncgymResponse<String>> updateMuscleGroup(CreateMuscleGroupReqRest req, String name) throws SyncgymException;

    ResponseEntity<SyncgymResponse<Object>> deleteMuscleGroup(String name) throws SyncgymException;
}
