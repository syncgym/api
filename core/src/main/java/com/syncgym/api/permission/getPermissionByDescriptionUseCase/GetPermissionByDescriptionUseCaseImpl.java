package com.syncgym.api.permission.getPermissionByDescriptionUseCase;

import com.syncgym.api.permission.Permission;
import com.syncgym.api.permission.exceptions.PermissionsNotFoundException;
import com.syncgym.api.permission.ports.PermissionRepositoryService;

public class GetPermissionByDescriptionUseCaseImpl implements GetPermissionByDescriptionUseCase {

    private final PermissionRepositoryService permissionRepositoryService;

    public GetPermissionByDescriptionUseCaseImpl(PermissionRepositoryService permissionRepositoryService) {
        this.permissionRepositoryService = permissionRepositoryService;
    }

    @Override
    public Permission execute(String description) throws PermissionsNotFoundException {
        return permissionRepositoryService.getPermissionByDescription(description)
                .orElseThrow(PermissionsNotFoundException::new);
    }
}
