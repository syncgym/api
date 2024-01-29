package com.syncgym.api.permission.ports;

import com.syncgym.api.permission.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionRepositoryService {

    Optional<List<Permission>> getAllPermissions();

    Optional<Permission> getPermissionByDescription(String description);
}
