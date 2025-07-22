package com.victor.login_api.user;

import com.victor.login_api.core.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Boolean enabled ;

    public User() {
    }

    public User(UserDTO dto) {
        this.id = dto.id();
        this.firstname = dto.firstname();
        this.lastname = dto.lastname();
        this.email = dto.email();
        this.password = dto.password();
        this.role = dto.role().get(0);
        this.enabled = dto.enabled();
    }

    public UserDTO toDTO() {
        return new UserDTO(this.id,this.firstname,this.lastname,this.email,this.password, List.of(this.role),this.enabled);
    }
}
