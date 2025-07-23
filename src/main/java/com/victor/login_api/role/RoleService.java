package com.victor.login_api.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    public void create(RoleDTO dto){
        roleRepository.save(new Role(dto));
    }

    public Role findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            return role.get();
        }
        throw new RuntimeException();
    }

}
