package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.dto.LoginDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserService userService;

    public LoginController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        System.out.println(loginDTO);
        Map<Object, Object> response = new HashMap<>();
        try {
            String userName = loginDTO.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, loginDTO.getPassword()));
            User user = userService.getUserByUserName(userName);
            //if user not exist or doesnt get from db
            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + userName + " not found");
            }
            /**else create response **/
            String token = jwtTokenProvider.createToken(userName, user.getUserRoles());
            response.put("userName", userName);
            response.put("token", token);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
        System.out.println(response.toString() + "__________________________--");
        return ResponseEntity.ok(response);
    }

}
