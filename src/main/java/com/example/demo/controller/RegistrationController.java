package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController

public class RegistrationController {
    @Autowired
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/registration")
    public void index(@RequestBody UserDTO userDTO) {
        userService.saveUser(new User("TEST", "TEST", "TEST", 100, Collections.singletonList(UserRole.User)));
        String userName = userDTO.getUserName();
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + userName + " not found");
        }
        User userToDb = new User();
        userToDb.setUserName(user.getUsername());
        userToDb.setAge(userDTO.getAge());
        userToDb.setEmail(userDTO.getEmail());
        userToDb.setPassword(userDTO.getPassword());
        userToDb.setUserRoles(Collections.singletonList(UserRole.User));
        userService.saveUser(userToDb);

    }
}
