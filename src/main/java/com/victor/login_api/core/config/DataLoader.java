package com.victor.login_api.core.config;

import com.victor.login_api.role.Role;
import com.victor.login_api.role.RoleDTO;
import com.victor.login_api.role.RoleService;
import com.victor.login_api.user.UserDTO;
import com.victor.login_api.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDatabase(UserService service, RoleService roleService) {
        return args -> {

            roleService.create(new RoleDTO("ADMIN"));
            roleService.create(new RoleDTO("USER"));
            roleService.create(new RoleDTO("CLIENT"));
            roleService.create(new RoleDTO("GUEST"));

            Set<Role> roles = new HashSet<>();
            Set<RoleDTO> roleDTOs = new HashSet<>();
            roles.addAll(roleService.findAll());
            for (Role role : roles) {
                roleDTOs.add(new RoleDTO(role.getName()));
            }


            UserDTO user2 = new UserDTO(null, "Ana Clara", "Silva", "ana.silva@example.com", "senha456", roleDTOs, true);

            UserDTO user3 = new UserDTO(null, "Carlos Eduardo", "Pereira", "carlos.pereira@example.com", "senha789", roleDTOs, true);

            UserDTO user4 = new UserDTO(null, "Mariana", "Costa", "mariana.costa@example.com", "minhasenha", roleDTOs, false);

            UserDTO user5 = new UserDTO(null, "João", "Oliveira", "joao.oliveira@example.com", "123456", roleDTOs, true);

            UserDTO user6 = new UserDTO(null, "Fernanda", "Souza", "fernanda.souza@example.com", "senha1234", roleDTOs, true);

            UserDTO user7 = new UserDTO(null, "Pedro Henrique", "Almeida", "pedro.almeida@example.com", "abc123", roleDTOs, true);

            service.create(user2);
            service.create(user3);
            service.create(user4);
            service.create(user5);
            service.create(user6);
            service.create(user7);
        };
    }
}
