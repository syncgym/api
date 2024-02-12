package com.syncgym.api.delivery.commonUser.impl;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.enums.Gender;
import com.syncgym.api.commonUser.ports.CommonUserRepositoryService;
import com.syncgym.api.delivery.commonUser.entities.CommonUserEntity;
import com.syncgym.api.delivery.commonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.commonUser.repositories.CommonUserRepository;
import com.syncgym.api.delivery.user.entities.UserEntity;
import com.syncgym.api.user.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommonUserServiceImpl implements CommonUserRepositoryService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CommonUserRepository commonUserRepository;

    @Autowired
    private CommonUserRepositoryMapper commonUserRepositoryMapper;

    @Override
    public Optional<CommonUser> findByUsername(String username) {
        return commonUserRepository.findByUserUsername(username)
                .map(commonUserRepositoryMapper::mapToDomain);
    }

    @Override
    @Transactional
    public CommonUser save(CommonUser commonUser, User user) {
        var userEntity = entityManager.find(UserEntity.class, user.id());

        var newCommonUser = new CommonUserEntity(
                userEntity,
                commonUser.firstName(),
                commonUser.lastName(),
                commonUser.dateOfBirth(),
                genderToBool(commonUser.gender()),
                commonUser.email()
        );

        var savedCommonUser = commonUserRepository.save(newCommonUser);

        return commonUserRepositoryMapper.mapToDomain(savedCommonUser);
    }

    private boolean genderToBool(Gender gender) {
        return switch (gender) {
            case MALE -> true;
            case FEMALE -> false;
        };
    }
}
