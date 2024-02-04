package com.syncgym.api.delivery.commonUser.mappers;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.enums.Gender;
import com.syncgym.api.delivery.commonUser.entities.CommonUserEntity;
import com.syncgym.api.delivery.user.mappers.UserRepositoryMapper;
import com.syncgym.api.shared.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonUserRepositoryMapper implements RepositoryMapper<CommonUserEntity, CommonUser> {

    @Autowired
    private UserRepositoryMapper userRepositoryMapper;

    @Override
    public CommonUserEntity mapToTable(final CommonUser user) {
        return new CommonUserEntity(
                user.id(),
                userRepositoryMapper.mapToTable(user.user()),
                user.firstName(),
                user.lastName(),
                user.dateOfBirth(),
                genderToBool(user.gender()),
                user.email()
        );
    }

    @Override
    public CommonUser mapToEntity(final CommonUserEntity userEntity) {
        return new CommonUser(
                userEntity.getId(),
                userRepositoryMapper.mapToEntity(userEntity.getUser()),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getDateOfBirth(),
                boolToGender(userEntity.isGender()),
                userEntity.getEmail()
        );
    }

    private boolean genderToBool(Gender gender) {
        return switch (gender) {
            case MALE -> true;
            case FEMALE -> false;
        };
    }

    private Gender boolToGender(boolean gender) {
        if (gender) return Gender.MALE;
        return Gender.FEMALE;
    }
}
