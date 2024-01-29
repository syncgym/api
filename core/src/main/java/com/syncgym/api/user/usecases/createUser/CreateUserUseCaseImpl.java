package com.syncgym.api.user.usecases.createUser;

import com.syncgym.api.permission.Permission;
import com.syncgym.api.user.User;
import com.syncgym.api.user.exceptions.UsernameAlreadyExists;
import com.syncgym.api.user.ports.UserRepositoryService;

import java.util.List;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryService userRepositoryService;

    public CreateUserUseCaseImpl(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    @Override
    public User execute(String username, String password, List<Permission> permissions) throws UsernameAlreadyExists {
        try {
            return userRepositoryService.save(username, password, permissions);
        } catch (Exception e) {
            throw new UsernameAlreadyExists(username);
        }

    }
}
