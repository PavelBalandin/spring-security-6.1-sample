package com.example.security.constants;

import static com.example.security.constants.Role.ROLE_USER;

public class SecurityConstants {

    public static final String BEARER = "Bearer";
    public static final String ROLES = "roles";
    public static final int BEARER_PREFIX_LENGTH = 7;
    public static final String DEFAULT_ROLE = ROLE_USER.name();


    private SecurityConstants() {

    }
}
