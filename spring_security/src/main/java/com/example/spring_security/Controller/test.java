package com.example.spring_security.Controller;


import com.example.spring_security.Model.User;
import com.example.spring_security.repository.UserRepository;

import com.example.spring_security.Model.Role;
import com.example.spring_security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/users")
public class test {
    private final UserRepository userRepository;
    public test(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @GetMapping("/usr")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
