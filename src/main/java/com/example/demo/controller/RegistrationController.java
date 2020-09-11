package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController

public class RegistrationController {
    @Autowired
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public ResponseEntity index(@RequestBody UserDTO userDTO) {
        // uncomment one time  if u need create user and after comment
        //  userService.saveUser(new User("TEST", passwordEncoder.encode("TEST"), "TEST", 100, Collections.singletonList(UserRole.User)));
        Map<Object, Object> response = new HashMap<>();
        User userToDb = new User();
        String userName = userDTO.getUserName();
        User user = userService.getUserByUserName(userName);
        /**if user not found in DB then we create and save user to DB**/
        if (user == null) {
            userToDb.setUserName(userDTO.getUserName());
            userToDb.setAge(userDTO.getAge());
            userToDb.setEmail(userDTO.getEmail());
            userToDb.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userToDb.setUserRoles(Collections.singletonList(UserRole.User));
            userService.saveUser(userToDb);
            response.put("use", userToDb);
            /**if user exist in db send message to front **/
        } else {
            response.put(400, "already exists");
            // throw new UsernameNotFoundException("User with username: " + userName + " not found");
        }
        return ResponseEntity.ok(response);
    }
}
