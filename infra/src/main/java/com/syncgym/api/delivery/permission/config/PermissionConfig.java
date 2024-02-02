package com.syncgym.api.delivery.permission.config;

import com.syncgym.api.delivery.permission.impl.PermissionServiceImpl;
import com.syncgym.api.delivery.permission.mappers.PermissionRepositoryMapper;
import com.syncgym.api.permission.getAllPermissionsUseCase.GetAllPermissionsUseCaseImpl;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PermissionConfig {

    @Bean
    public PermissionRepositoryMapper permissionRepositoryMapper() {
        return new PermissionRepositoryMapper();
    }

    @Bean
    public PermissionServiceImpl permissionService() {
        return new PermissionServiceImpl();
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
