package com.syncgym.api.permission.getAllPermissionsUseCase;

import com.syncgym.api.permission.Permission;
import com.syncgym.api.permission.exceptions.PermissionsNotFoundException;
import com.syncgym.api.permission.ports.PermissionRepositoryService;

import java.util.Collection;

public class GetAllPermissionsUseCaseImpl implements GetAllPermissionsUseCase {

    private final PermissionRepositoryService permissionRepositoryService;

    public GetAllPermissionsUseCaseImpl(PermissionRepositoryService permissionRepositoryService) {
        this.permissionRepositoryService = permissionRepositoryService;
    }

    @Override
    public Collection<Permission> execute() throws PermissionsNotFoundException {
        return permissionRepositoryService.getAllPermissions()
                .orElseThrow(PermissionsNotFoundException::new);
    }
}
