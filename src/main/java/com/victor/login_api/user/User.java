package com.victor.login_api.user;

import com.victor.login_api.role.Role;
import com.victor.login_api.role.RoleDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

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

    @ManyToMany
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

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
        this.roles = dto.role().stream()
                .map(Role::new)
                .collect(Collectors.toSet());
        this.enabled = dto.enabled();
    }

    public UserDTO toDTO() {
        Set<RoleDTO> roleDTOs = new HashSet<>();
        for (Role role : this.roles) {
            roleDTOs.add(new RoleDTO(role.getName()));
        }
        return new UserDTO(
                this.id,
                this.firstname,
                this.lastname,
                this.email,
                this.password,
                roleDTOs,
                this.enabled
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }


}
