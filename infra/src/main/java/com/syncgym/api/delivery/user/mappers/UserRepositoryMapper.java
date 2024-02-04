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
    public UserEntity mapToEntity(final User domain) {
        var permissions = domain.permissions().stream()
                .map(permissionRepositoryMapper::mapToEntity)
                .toList();

        return new UserEntity(
                domain.id(),
                domain.username(),
                domain.password(),
                domain.accountNonExpired(),
                domain.accountNonLocked(),
                domain.credentialsNonExpired(),
                domain.enabled(),
                permissions
        );
    }

    @Override
    public User mapToDomain(final UserEntity entity) {
        var permissions = entity.getPermissions().stream()
                .map(permissionRepositoryMapper::mapToDomain)
                .toList();

        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.isAccountNonExpired(),
                entity.isAccountNonLocked(),
                entity.isCredentialsNonExpired(),
                entity.isEnabled(),
                permissions
        );
    }
}
