package com.syncgym.api.delivery.permission.impl;

import com.syncgym.api.delivery.permission.mappers.PermissionRepositoryMapper;
import com.syncgym.api.delivery.permission.repositories.PermissionRepository;
import com.syncgym.api.permission.Permission;
import com.syncgym.api.permission.ports.PermissionRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PermissionServiceImpl implements PermissionRepositoryService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionRepositoryMapper permissionRepositoryMapper;

    @Override
    public Optional<List<Permission>> getAllPermissions() {
        return Optional.of(
                permissionRepository.findAll()
                        .stream().map(permissionRepositoryMapper::mapToEntity).toList()
        );
    }

    @Override
    public Optional<Permission> getPermissionByDescription(String description) {
        return permissionRepository.findByDescription(description)
                .map(permissionRepositoryMapper::mapToEntity);
    }
}
