package com.victor.login_api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        User user = new User(dto);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        this.userRepository.save(user);
    }
}
