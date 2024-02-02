package com.syncgym.api.delivery.CommonUser;

import com.syncgym.api.delivery.CommonUser.rest.CommonUserResponseRest;
import com.syncgym.api.delivery.CommonUser.rest.CommonUserRest;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

public interface CommonUserController {

    ResponseEntity<SyncgymResponse<CommonUserResponseRest>> getCommonUserByUsername(String username) throws SyncgymException;

    ResponseEntity<SyncgymResponse<CommonUserResponseRest>> createCommonUser(CommonUserRest commonUserRest) throws SyncgymException;
}
