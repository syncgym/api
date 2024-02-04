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
    public CommonUserEntity mapToEntity(final CommonUser domain) {
        return new CommonUserEntity(
                domain.id(),
                userRepositoryMapper.mapToEntity(domain.user()),
                domain.firstName(),
                domain.lastName(),
                domain.dateOfBirth(),
                genderToBool(domain.gender()),
                domain.email()
        );
    }

    @Override
    public CommonUser mapToDomain(final CommonUserEntity entity) {
        return new CommonUser(
                entity.getId(),
                userRepositoryMapper.mapToDomain(entity.getUser()),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getDateOfBirth(),
                boolToGender(entity.isGender()),
                entity.getEmail()
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
