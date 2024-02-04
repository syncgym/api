package com.syncgym.api.delivery.commonUser.mappers;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.delivery.commonUser.rest.CommonUserRest;
import com.syncgym.api.shared.RestMapper;

public class CommonUserRestMapper implements RestMapper<CommonUserRest, CommonUser> {

    @Override
    public CommonUser mapToDomain(final CommonUserRest rest) {

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
    public CommonUserRest mapToRest(CommonUser domain) {
        return new CommonUserRest(
                domain.user().username(),
                domain.user().password(),
                domain.firstName(),
                domain.lastName(),
                domain.gender(),
                domain.email(),
                domain.dateOfBirth()
        );
    }
}
