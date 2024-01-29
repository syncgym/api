package com.syncgym.api.permission.getPermissionByDescriptionUseCase;

import com.syncgym.api.permission.Permission;
import com.syncgym.api.permission.exceptions.PermissionsNotFoundException;

public interface GetPermissionByDescriptionUseCase {

    Permission execute(String description) throws PermissionsNotFoundException;
}
