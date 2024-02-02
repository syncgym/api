package com.syncgym.api.delivery.user.mappers;

import com.syncgym.api.delivery.permission.mappers.PermissionRepositoryMapper;
import com.syncgym.api.delivery.user.entities.UserEntity;
import com.syncgym.api.shared.RepositoryMapper;
import com.syncgym.api.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryMapper implements RepositoryMapper<UserEntity, User> {

    @Autowired
    private PermissionRepositoryMapper permissionRepositoryMapper;

    @Override
    public UserEntity mapToTable(final User user) {
        var permissions = user.permissions().stream()
                .map(permissionRepositoryMapper::mapToTable)
                .toList();

        return new UserEntity(
                user.id(),
                user.username(),
                user.password(),
                user.accountNonExpired(),
                user.accountNonLocked(),
                user.credentialsNonExpired(),
                user.enabled(),
                permissions
        );
    }

    @Override
    public User mapToEntity(final UserEntity userEntity) {
        var permissions = userEntity.getPermissions().stream()
                .map(permissionRepositoryMapper::mapToEntity)
                .toList();

        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isAccountNonExpired(),
                userEntity.isAccountNonLocked(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isEnabled(),
                permissions
        );
    }
}
