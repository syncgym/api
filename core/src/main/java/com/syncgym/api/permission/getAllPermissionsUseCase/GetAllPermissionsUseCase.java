package com.syncgym.api.permission.getAllPermissionsUseCase;

import com.syncgym.api.permission.Permission;
import com.syncgym.api.permission.exceptions.PermissionsNotFoundException;

import java.util.Collection;

public interface GetAllPermissionsUseCase {

    Collection<Permission> execute() throws PermissionsNotFoundException;
}
