package com.syncgym.api.user.usecases.createUser;

import com.syncgym.api.permission.Permission;
import com.syncgym.api.user.User;
import com.syncgym.api.user.exceptions.UsernameAlreadyExists;

import java.util.List;

public interface CreateUserUseCase {

    User execute(String username, String password, List<Permission> permissions) throws UsernameAlreadyExists;
}
