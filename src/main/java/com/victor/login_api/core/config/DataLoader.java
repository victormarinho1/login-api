package com.victor.login_api.core.config;

import com.victor.login_api.core.Role;
import com.victor.login_api.user.UserDTO;
import com.victor.login_api.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDatabase(UserService service) {
        return args -> {

            UserDTO user2 = new UserDTO(null, "Ana Clara", "Silva", "ana.silva@example.com", "senha456", List.of(Role.ADMIN), true);

            UserDTO user3 = new UserDTO(null, "Carlos Eduardo", "Pereira", "carlos.pereira@example.com", "senha789", List.of(Role.CLIENT, Role.EMPLOYEE2), true);

            UserDTO user4 = new UserDTO(null, "Mariana", "Costa", "mariana.costa@example.com", "minhasenha", List.of(Role.CLIENT), false);

            UserDTO user5 = new UserDTO(null, "João", "Oliveira", "joao.oliveira@example.com", "123456", List.of(Role.CLIENT), true);

            UserDTO user6 = new UserDTO(null, "Fernanda", "Souza", "fernanda.souza@example.com", "senha1234", List.of(Role.CLIENT, Role.ADMIN), true);

            UserDTO user7 = new UserDTO(null, "Pedro Henrique", "Almeida", "pedro.almeida@example.com", "abc123", List.of(Role.CLIENT), true);

            service.create(user2);
            service.create(user3);
            service.create(user4);
            service.create(user5);
            service.create(user6);
            service.create(user7);
        };
    }
}
