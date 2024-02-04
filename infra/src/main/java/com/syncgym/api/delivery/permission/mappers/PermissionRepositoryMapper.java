package com.syncgym.api.delivery.permission.mappers;

import com.syncgym.api.delivery.permission.entities.PermissionEntity;
import com.syncgym.api.permission.Permission;
import com.syncgym.api.shared.RepositoryMapper;

public class PermissionRepositoryMapper implements RepositoryMapper<PermissionEntity, Permission> {

    @Override
    public PermissionEntity mapToEntity(final Permission domain) {
        return new PermissionEntity(domain.id(), domain.description());
    }

    @Override
    public Permission mapToDomain(final PermissionEntity entity) {
        return new Permission(entity.getId(), entity.getDescription());
    }
}
