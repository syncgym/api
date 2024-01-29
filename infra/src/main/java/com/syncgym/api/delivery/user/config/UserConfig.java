package com.syncgym.api.delivery.user.config;

import com.syncgym.api.delivery.permission.mappers.PermissionRepositoryMapper;
import com.syncgym.api.delivery.user.impl.UserServiceImpl;
import com.syncgym.api.delivery.user.mappers.UserRepositoryMapper;
import com.syncgym.api.delivery.user.repositories.UserRepository;
import com.syncgym.api.user.usecases.createUser.CreateUserUseCaseImpl;
import com.syncgym.api.user.usecases.findUserByUsername.FindUserByUsernameUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepositoryMapper permissionRepositoryMapper;

    @Bean
    public UserRepositoryMapper userRepositoryMapper() {
        return new UserRepositoryMapper(permissionRepositoryMapper);
    }

    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl(userRepository, userRepositoryMapper(), permissionRepositoryMapper);
    }

    @Bean
    public CreateUserUseCaseImpl createUserUseCase() {
        return new CreateUserUseCaseImpl(userService());
    }

    @Bean
    public FindUserByUsernameUseCaseImpl findUserByUsernameUseCase() {
        return new FindUserByUsernameUseCaseImpl(userService());
    }
}
