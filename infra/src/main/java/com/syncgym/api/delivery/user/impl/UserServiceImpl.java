package com.syncgym.api.delivery.user.impl;

import com.syncgym.api.delivery.permission.mappers.PermissionRepositoryMapper;
import com.syncgym.api.delivery.user.entities.UserEntity;
import com.syncgym.api.delivery.user.mappers.UserRepositoryMapper;
import com.syncgym.api.delivery.user.repositories.UserRepository;
import com.syncgym.api.permission.Permission;
import com.syncgym.api.user.User;
import com.syncgym.api.user.ports.UserRepositoryService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserRepositoryService {

    private final UserRepository userRepository;

    private final UserRepositoryMapper userRepositoryMapper;

    private final PermissionRepositoryMapper permissionRepositoryMapper;

    public UserServiceImpl(UserRepository userRepository, UserRepositoryMapper userRepositoryMapper, PermissionRepositoryMapper permissionRepositoryMapper) {
        this.userRepository = userRepository;
        this.userRepositoryMapper = userRepositoryMapper;
        this.permissionRepositoryMapper = permissionRepositoryMapper;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .map(userRepositoryMapper::mapToEntity);
    }

    @Override
    public User save(String username, String password, List<Permission> permissions) {
        var permissionsEntity = permissions.stream().map(permissionRepositoryMapper::mapToTable).toList();
        var user = userRepository.save(new UserEntity(username, password, permissionsEntity));

        return userRepositoryMapper.mapToEntity(user);
    }
}
