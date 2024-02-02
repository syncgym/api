package com.syncgym.api.commonUser;

import com.syncgym.api.commonUser.enums.Gender;
import com.syncgym.api.user.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record CommonUser(
        Long id,
        User user,
        String firstName,
        String lastName,
        Date dateOfBirth,
        Gender gender,
        String email

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
