package com.syncgym.api.delivery.CommonUser.impl;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.enums.Gender;
import com.syncgym.api.commonUser.ports.CommonUserRepositoryService;
import com.syncgym.api.delivery.CommonUser.entities.CommonUserEntity;
import com.syncgym.api.delivery.CommonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.CommonUser.repositories.CommonUserRepository;
import com.syncgym.api.delivery.user.entities.UserEntity;
import com.syncgym.api.delivery.user.mappers.UserRepositoryMapper;
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

    @Autowired
    private UserRepositoryMapper userRepositoryMapper;

    @Override
    public Optional<CommonUser> findById(Long id) {
        return commonUserRepository.findById(id)
                .map(commonUserRepositoryMapper::mapToEntity);
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

        return commonUserRepositoryMapper.mapToEntity(savedCommonUser);
    }

    private boolean genderToBool(Gender gender) {
        return switch (gender) {
            case MALE -> true;
            case FEMALE -> false;
        };
    }
}
