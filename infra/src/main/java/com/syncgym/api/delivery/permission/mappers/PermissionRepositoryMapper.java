package com.syncgym.api.delivery.permission.mappers;

import com.syncgym.api.delivery.permission.entities.PermissionEntity;
import com.syncgym.api.permission.Permission;
import com.syncgym.api.shared.RepositoryMapper;

public class PermissionRepositoryMapper implements RepositoryMapper<PermissionEntity, Permission> {

    @Override
    public PermissionEntity mapToTable(final Permission permission) {
        return new PermissionEntity(permission.id(), permission.description());
    }

    @Override
    public Permission mapToEntity(final PermissionEntity permissionEntity) {
        return new Permission(permissionEntity.getId(), permissionEntity.getDescription());
    }
}
