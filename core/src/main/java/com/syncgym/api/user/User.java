package com.syncgym.api.user;

import com.syncgym.api.permission.Permission;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record User(
        Long id,
        String username,
        String password,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired,
        boolean enabled,
        List<Permission> permissions
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
