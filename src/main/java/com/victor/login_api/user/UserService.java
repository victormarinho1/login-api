package com.victor.login_api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public void create(UserDTO dto){
        this.userRepository.save(new User(dto));
    }
}
