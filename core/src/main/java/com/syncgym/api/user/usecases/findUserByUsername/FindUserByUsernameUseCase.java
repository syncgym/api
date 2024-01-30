package com.syncgym.api.user.usecases.findUserByUsername;

import com.syncgym.api.user.User;
import com.syncgym.api.user.exceptions.UserNotFoundException;

public interface FindUserByUsernameUseCase {

    User execute(String username) throws UserNotFoundException;
}
