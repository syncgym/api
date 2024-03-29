package com.syncgym.api.delivery.commonUser.responses;

import com.syncgym.api.delivery.commonUser.rest.CommonUserResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class CommonUserResponse extends SyncgymResponse<CommonUserResponseRest> {

    public CommonUserResponse(String status, int code, String message, CommonUserResponseRest data) {
        super(status, code, message, data);
    }
}
