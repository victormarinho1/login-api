package com.victor.login_api.user;

import com.victor.login_api.core.Role;

import java.util.List;

public record UserDTO(
        Long id,
        String firstname,
        String lastname,
        String email,
        String password,
        List<Role> role,
        Boolean enabled
) {
}
