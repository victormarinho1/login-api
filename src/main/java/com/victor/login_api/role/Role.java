package com.victor.login_api.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.victor.login_api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "roles")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean enabled;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(RoleDTO dto) {
        this.id = null;
        this.name = dto.name();
        this.enabled = true;

    }

    public Role(Role role) {
        this.name = role.getName();
        this.enabled = role.getEnabled();
    }

}
