package com.syncgym.api.user.ports;

import com.syncgym.api.permission.Permission;
import com.syncgym.api.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryService {

    Optional<User> findUserByUsername(String username);

    User save(String username, String password, List<Permission> permissions);
}
