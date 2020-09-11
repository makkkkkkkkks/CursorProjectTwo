package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.getUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.getByUserName(s);
    }

    @Override
    public User getUserByUserName(String name) {
        return userRepo.getByUserName(name);
    }

    @Override
    public void saveUser(User user) {
        userRepo.saveAndFlush(user);
    }

    @Override
    public boolean userIsExisting(String name) {
       // User user =  userRepo.userIsExisting(userRepo.getByUserName(name));

        return false;
    }
}
