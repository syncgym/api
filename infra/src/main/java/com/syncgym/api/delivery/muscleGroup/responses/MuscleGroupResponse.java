package com.syncgym.api.delivery.muscleGroup.responses;

import com.syncgym.api.shared.responses.SyncgymResponse;

public class MuscleGroupResponse extends SyncgymResponse<String> {

    public MuscleGroupResponse(String status, int code, String message, String data) {
        super(status, code, message, data);
    }
}
