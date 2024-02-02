package com.syncgym.api.security.rest;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record Token(
        String username,
        Boolean authenticated,
        Date created,
        Date expiration,
        String accessToken,
        String refreshToken
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
