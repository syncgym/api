package com.syncgym.api.delivery.commonUser.mappers;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.delivery.commonUser.rest.CommonUserResponseRest;
import com.syncgym.api.shared.RestMapper;

public class CommonUserResponseRestMapper implements RestMapper<CommonUserResponseRest, CommonUser> {

    @Override
    public CommonUser mapToEntity(final CommonUserResponseRest rest) {

        return new CommonUser(
                null,
                null,
                rest.firstName(),
                rest.lastName(),
                rest.dateOfBirth(),
                rest.gender(),
                rest.email()
        );
    }

    @Override
    public CommonUserResponseRest mapToRest(CommonUser entity) {
        return new CommonUserResponseRest(
                entity.user().username(),
                entity.firstName(),
                entity.lastName(),
                entity.gender(),
                entity.email(),
                entity.dateOfBirth()
        );
    }
}
