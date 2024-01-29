package com.syncgym.api.user.usecases.findUserByUsername;

import com.syncgym.api.user.User;
import com.syncgym.api.user.exceptions.UserNotFoundException;
import com.syncgym.api.user.ports.UserRepositoryService;

public class FindUserByUsernameUseCaseImpl implements FindUserByUsernameUseCase {

    private final UserRepositoryService userRepositoryService;

    public FindUserByUsernameUseCaseImpl(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    @Override
    public User execute(String username) throws UserNotFoundException {
        return userRepositoryService.findUserByUsername(username)
                .orElseThrow(UserNotFoundException::new);
    }
}
