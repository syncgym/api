package com.syncgym.api.delivery.commonUser.mappers;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.delivery.commonUser.rest.CommonUserRest;
import com.syncgym.api.shared.RestMapper;

public class CommonUserRestMapper implements RestMapper<CommonUserRest, CommonUser> {

    @Override
    public CommonUser mapToEntity(final CommonUserRest rest) {

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
    public CommonUserRest mapToRest(CommonUser entity) {
        return new CommonUserRest(
                entity.user().username(),
                entity.user().password(),
                entity.firstName(),
                entity.lastName(),
                entity.gender(),
                entity.email(),
                entity.dateOfBirth()
        );
    }
}
