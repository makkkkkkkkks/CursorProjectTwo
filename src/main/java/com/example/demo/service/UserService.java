package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public void saveUser(User user);
    public User getUserById(Long id);
    public User getUserByUserName(String name);

}
