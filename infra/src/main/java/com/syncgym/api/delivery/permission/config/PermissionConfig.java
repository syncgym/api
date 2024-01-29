package com.syncgym.api.delivery.permission.config;

import com.syncgym.api.delivery.permission.impl.PermissionServiceImpl;
import com.syncgym.api.delivery.permission.mappers.PermissionRepositoryMapper;
import com.syncgym.api.delivery.permission.repositories.PermissionRepository;
import com.syncgym.api.permission.getAllPermissionsUseCase.GetAllPermissionsUseCaseImpl;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PermissionConfig {

    @Autowired
    private PermissionRepository permissionRepository;

    @Bean
    public PermissionRepositoryMapper permissionRepositoryMapper() {
        return new PermissionRepositoryMapper();
    }

    @Bean
    public PermissionServiceImpl permissionService() {
        return new PermissionServiceImpl(permissionRepository, permissionRepositoryMapper());
    }

    @Bean
    GetAllPermissionsUseCaseImpl getAllPermissionsUseCase() {
        return new GetAllPermissionsUseCaseImpl(permissionService());
    }

    @Bean
    GetPermissionByDescriptionUseCaseImpl getPermissionByDescriptionUseCase() {
        return new GetPermissionByDescriptionUseCaseImpl(permissionService());
    }
}
