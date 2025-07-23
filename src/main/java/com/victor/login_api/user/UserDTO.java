package com.victor.login_api.user;

import com.victor.login_api.role.Role;
import com.victor.login_api.role.RoleDTO;

import java.util.Set;

public record UserDTO(
        Long id,
        String firstname,
        String lastname,
        String email,
        String password,
        Set<RoleDTO> role,
        Boolean enabled
) {
}
