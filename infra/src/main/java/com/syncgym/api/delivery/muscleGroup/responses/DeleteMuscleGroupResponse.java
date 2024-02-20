package com.syncgym.api.delivery.muscleGroup.responses;

import com.syncgym.api.shared.responses.SyncgymResponse;

public class DeleteMuscleGroupResponse extends SyncgymResponse<Object> {

    public DeleteMuscleGroupResponse(String status, int code, String message) {
        super(status, code, message);
    }
}