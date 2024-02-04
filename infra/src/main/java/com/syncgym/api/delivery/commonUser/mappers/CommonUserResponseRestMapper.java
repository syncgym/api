package com.syncgym.api.delivery.commonUser.mappers;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.delivery.commonUser.rest.CommonUserResponseRest;
import com.syncgym.api.shared.RestMapper;

public class CommonUserResponseRestMapper implements RestMapper<CommonUserResponseRest, CommonUser> {

    @Override
    public CommonUser mapToDomain(final CommonUserResponseRest rest) {

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
    public CommonUserResponseRest mapToRest(CommonUser domain) {
        return new CommonUserResponseRest(
                domain.user().username(),
                domain.firstName(),
                domain.lastName(),
                domain.gender(),
                domain.email(),
                domain.dateOfBirth()
        );
    }
}
