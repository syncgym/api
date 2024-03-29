package com.syncgym.api.commonUser.ports;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.user.User;

import java.util.Optional;

public interface CommonUserRepositoryService {

    Optional<CommonUser> findByUsername(String username);

    CommonUser save(CommonUser commonUser, User user);
}
