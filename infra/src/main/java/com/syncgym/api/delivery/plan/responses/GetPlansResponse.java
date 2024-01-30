package com.syncgym.api.delivery.plan.responses;

import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class GetPlansResponse extends SyncgymResponse<List<String>> {

    public GetPlansResponse(String status, int code, String message, List<String> data) {
        super(status, code, message, data);
    }
}
