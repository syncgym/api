package com.syncgym.api.delivery.muscleGroup.responses;

import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class ListOfMuscleGroupResponse extends SyncgymResponse<List<String>> {

    public ListOfMuscleGroupResponse(String status, int code, String message, List<String> data) {
        super(status, code, message, data);
    }
}
