package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String password;
    private String email;
    private Integer age;

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);
        user.setUserName(userName);
        return user;
    }


}
